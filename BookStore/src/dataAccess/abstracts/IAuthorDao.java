package dataAccess.abstracts;

import entities.concretes.Author;

import java.util.List;

public interface IAuthorDao {
    void add(Author author);

    void delete(int author_id);

    void update(Author author);

    Author get(int author_id);

    List<Author> getAll();

}
