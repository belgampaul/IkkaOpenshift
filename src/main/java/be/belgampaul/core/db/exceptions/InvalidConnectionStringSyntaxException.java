package be.belgampaul.core.db.exceptions;

/**
 * @author ikka
 * @date: 15.07.2015.
 */
public class InvalidConnectionStringSyntaxException extends Exception {
  private static String DEFAULT_ERR_MSG = "Connection string is incorrect due to missing information.";
  public InvalidConnectionStringSyntaxException() {
    super(DEFAULT_ERR_MSG);
  }

  public InvalidConnectionStringSyntaxException(String message) {
    super(message);
  }

  public InvalidConnectionStringSyntaxException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidConnectionStringSyntaxException(Throwable cause) {
    super(DEFAULT_ERR_MSG, cause);
  }

  public InvalidConnectionStringSyntaxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
