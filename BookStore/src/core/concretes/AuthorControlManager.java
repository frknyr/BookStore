package core.concretes;

import core.abstracts.IAuthorControlService;
import entities.concretes.Author;

import java.util.List;

public class AuthorControlManager implements IAuthorControlService {

    // Girilen ID'ye sahip olan yazar var mı diye kontrol ediliyor
    @Override
    public boolean controlAuthorId(int author_id, List<Author> authors) {
        for (Author controlAuthor : authors) {
            if (controlAuthor.getAuthor_id() == author_id) {
                return true;
            }
        }
        return false;
    }

    // Yeni yazar eklenirken aynı ad ve soyada sahip yazar var mı diye kontrol ediliyor
    @Override
    public boolean controlAuthorNameSurnameUsed(Author author, List<Author> authors) {
        for (Author controlAuthor : authors) {
            if (controlAuthor.getAuthor_name().equals(author.getAuthor_name()) &&
                    controlAuthor.getAuthor_surname().equals(author.getAuthor_surname())) {
                return false;
            }
        }
        return true;
    }

    // Yazar adının uzunluğu kontrol ediliyor
    @Override
    public boolean controlAuthorName(Author author) {
        if (author.getAuthor_name().length() < 2) {
            return false;
        }
        return true;
    }

    // Yazar soyadının uzunluğu kontrol ediliyor
    @Override
    public boolean controlAuthorSurname(Author author) {
        if (author.getAuthor_surname().length() < 2) {
            return false;
        }
        return true;
    }
}
