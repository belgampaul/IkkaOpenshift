package be.belgampaul.entities.survey;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ikka
 * @date: 05.08.2015.
 */
public class Question {
  private String questionText;
  private List<OfferedAnswer> offeredAnswers;
  private List<QuestionType> properties;

  public Question() {
    offeredAnswers = new ArrayList<>();
  }


}
