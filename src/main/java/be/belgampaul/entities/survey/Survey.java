package be.belgampaul.entities.survey;

import be.belgampaul.entities.survey.Question;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ikka
 * @date: 05.08.2015.
 */
public class Survey {
  private String description;
  private Date startDate;
  private Date endDate;
  private boolean isOpen;

  private List<Question> questions;

  public Survey() {
    questions = new ArrayList<>();
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void setIsOpen(boolean isOpen) {
    this.isOpen = isOpen;
  }

  public boolean addQuestion(Question question) {
    return questions.add(question);
  }

  public boolean removeQuestion(Question question) {
    return questions.remove(question);
  }
}
