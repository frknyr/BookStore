package core.abstracts;

import entities.concretes.Author;
import java.util.List;

public interface IAuthorControlService {
    boolean controlAuthorId(int author_id, List<Author> authors);
    boolean controlAuthorNameSurnameUsed(Author author, List<Author> authors);
    boolean controlAuthorName(Author author);
    boolean controlAuthorSurname(Author author);

}
