  package be.belgampaul.core.db.metamodel.relational;

import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.hibernate.metamodel.relational.Column;
import org.hibernate.metamodel.relational.Size;
import org.hibernate.metamodel.relational.TableSpecification;
import org.w3._2001.xmlschema.*;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.sql.JDBCType;
import java.util.List;

/**
 * @author ikka
 * @date: 13.07.2015.
 */
public class DBColumn extends Column {
  public static final String INTEGER = "integer";
  public static final String STRING = "string";
  public static final String DATE= "date";


  private Integer minLength;
  private Integer maxLength;
  private List<Object> documentationList;
  private Restriction restriction;

  private TopLevelAttribute topLevelAttribute;

  public DBColumn(TopLevelAttribute topLevelAttribute, int position) {
    this(null, position, topLevelAttribute.getName().getValue().getValue());
    this.topLevelAttribute = topLevelAttribute;

    restriction = getRestrictionSafely();

    //required
    String value = topLevelAttribute.getUse().getValue();
    Attribute.Use.Enum useEnum = Attribute.Use.Enum.forString(value);
    setNullable(!useEnum.equals(Attribute.Use.Enum.forInt(3)));

    //documentation
    documentationList = ((Documentation) topLevelAttribute.getAnnotation().getAppinfoOrDocumentation().get(0)).getContent();
    setComment(documentationList);

    //type
    if (restriction != null) {
      setSqlType(restriction.getBase());
    } else {
      setSqlType(topLevelAttribute.getType());
    }

    //size
    setSize(restriction);


    //calcualte column size
    getSize().setLength(calculateSizeLength());

  }

  private long calculateSizeLength() {
    Size size = getSize();
    return Math.max(Math.max(getMinLength(), getMaxLength()), size.getLength());
  }

  private Restriction getRestrictionSafely() {
    if (topLevelAttribute != null && topLevelAttribute.getSimpleType() != null) {
      return topLevelAttribute.getSimpleType().getRestriction();
    }
    return null;
  }

  public Integer getMinLength() {
    return minLength == null ? 0 : minLength;
  }

  public void setMinLength(Integer minLength) {
    this.minLength = minLength;
  }

  public Integer getMaxLength() {
    return maxLength == null ? 0 : maxLength;
  }

  public void setMaxLength(Integer maxLength) {
    this.maxLength = maxLength;
  }

  private void setComment(List<Object> documentationList) {
    StringBuilder stringBuilder = new StringBuilder();
    documentationList.stream().forEach(o -> stringBuilder.append(o.toString()));
    setComment(stringBuilder.toString());
  }

  public DBColumn(TableSpecification table, int position, String name) {
    super(table, position, name);
  }


  public void setSize(Restriction restriction) {
    if (restriction == null) {
      return;
    }
    for (Object o : restriction.getFacets()) {
      if (o instanceof TotalDigits) {
        if (INTEGER.equals(getSqlType())) {
          TotalDigits totalDigits = (TotalDigits) o;
          String totalDigitsAsString = totalDigits.getValue();
          setSize(new Size(-1, -1, Integer.parseInt(totalDigitsAsString), null));
        }
      } else if (o instanceof JAXBElement && ((JAXBElement) o).getName().equals(ObjectFactoryQNameConstants._MinLength_QNAME)) {
        minLength = getValueFromNumFacet((JAXBElement) o);
      } else if (o instanceof JAXBElement && ((JAXBElement) o).getName().equals(ObjectFactoryQNameConstants._MaxLength_QNAME)) {
        maxLength = getValueFromNumFacet((JAXBElement) o);
      }

    }
  }

  private Integer getValueFromNumFacet(JAXBElement jaxbElement) {
    Object value = jaxbElement.getValue();
    if (value instanceof NumFacet) {
      NumFacet numFacet = (NumFacet) value;
      return Integer.parseInt(numFacet.getValue());
    }
    return null;
  }


  public void setSqlType(QName qName) {
    String namespaceURI = qName.getNamespaceURI();
    if (namespaceURI.equals(XMLConstants.W3C_XML_SCHEMA_NS_URI)) {
      String xmlTypeNameLocalPart = qName.getLocalPart();//only local part.
      switch (xmlTypeNameLocalPart) {
        case INTEGER:
          super.setSqlType(JDBCType.INTEGER.name().toLowerCase());
          break;

        case STRING:
          super.setSqlType(JDBCType.VARCHAR.name().toLowerCase());
          break;

        case DATE:
          super.setSqlType(JDBCType.DATE.name().toLowerCase());
          break;
      }
    }
  }

  @Override
  public String toString() {
    return "DBColumn{" +
        "columnName=" + getColumnName() +
        ", sqlType=" + getSqlType() +
        ", isNullable=" + isNullable() +
        ", length=" + getSize().getLength() +
        ", minLength=" + minLength +
        ", maxLength=" + maxLength +
        ", comment=" + getComment()+
        '}';
  }
}
