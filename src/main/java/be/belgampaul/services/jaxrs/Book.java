package be.belgampaul.services.jaxrs;

/**
 * @author ikka
 * @date: 28.07.2015.
 */
public class Book {

  String isbn;
  String title;
  Long id;

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public static Book newBook(String id, String isbn, String title) {
    Book book = new Book();
    book.setId(Long.valueOf(id));
    book.setIsbn(isbn);
    book.setTitle(title);
    return book;
  }
}
