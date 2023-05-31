package dataAccess.abstracts;

import entities.concretes.Book;

import java.util.List;

public interface IBookDao {
    void add(Book book);

    void delete(int book_id);

    void update(Book book);

    Book get(int book_id);

    List<Book> getAll();

}
