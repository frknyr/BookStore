package core.abstracts;

import entities.concretes.Book;

import java.util.List;

public interface IBookControlService {
    boolean controlBookName(Book book);
    boolean controlBookExplanation(Book book);
    boolean controlBookPrice(Book book);
    boolean controlBookId(int book_id, List<Book> books);


}
