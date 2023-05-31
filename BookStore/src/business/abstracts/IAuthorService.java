package business.abstracts;

import entities.concretes.Author;
import java.util.List;

public interface IAuthorService {
    void add(Author author);

    void delete(int author_id);

    void update(Author author);

    Author get(int author_id);

    List<Author> getAll();
}
