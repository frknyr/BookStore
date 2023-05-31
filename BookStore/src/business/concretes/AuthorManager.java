package business.concretes;

import business.abstracts.IAuthorService;
import core.abstracts.IAuthorControlService;
import dataAccess.abstracts.IAuthorDao;
import entities.concretes.Author;

import java.util.List;

public class AuthorManager implements IAuthorService {
    private IAuthorDao authorDao;
    private IAuthorControlService authorControlService;

    public AuthorManager(IAuthorDao authorDao, IAuthorControlService authorControlService) {
        this.authorDao = authorDao;
        this.authorControlService = authorControlService;
    }

    @Override
    public void add(Author author) {
        if (!authorControlService.controlAuthorNameSurnameUsed(author, getAll())) {
            System.out.println(author.getAuthor_name() + " " + author.getAuthor_surname() + " " +
                    "adında bir yazar bulunuyor !");
            return;
        }
        if (!authorControlService.controlAuthorName(author)) {
            System.out.println("Yazar adı en az 2 karakterden oluşmalıdır !");
        }
        if (!authorControlService.controlAuthorSurname(author)) {
            System.out.println("Yazar soyadı ene az 2 karakterden oluşmalıdır !");
            return;
        }

        if (authorControlService.controlAuthorNameSurnameUsed(author, getAll()) &&
                authorControlService.controlAuthorName(author) && authorControlService.controlAuthorSurname(author)) {
            authorDao.add(author);
            System.out.println(author.getAuthor_name() + " " + author.getAuthor_surname() + " adlı yazar eklendi");
        }


    }

    @Override
    public void delete(int author_id) {
        if (authorControlService.controlAuthorId(author_id, getAll())) {
            authorDao.delete(author_id);
            System.out.println(author_id + " id numaralı yazar silindi");
        } else {
            System.out.println(author_id + " id numarasına sahip yazar bulunmuyor !");
        }
    }

    @Override
    public void update(Author author) {
        if (!authorControlService.controlAuthorId(author.getAuthor_id(), getAll())) {
            System.out.println(author.getAuthor_id() + " numaralı ID'ye sahip yazar bulunmuyor");
            return;
        }

        if (!authorControlService.controlAuthorName(author)) {
            System.out.println("Yazar adı en az 2 karakterden oluşmalıdır !");
        }
        if (!authorControlService.controlAuthorSurname(author)) {
            System.out.println("Yazar soyadı ene az 2 karakterden oluşmalıdır !");
            return;
        }

        if (!authorControlService.controlAuthorNameSurnameUsed(author, getAll())) {
            System.out.println(author.getAuthor_name() + " " + author.getAuthor_surname() + " " +
                    "adında bir yazar bulunuyor !");
            return;
        }

        if (authorControlService.controlAuthorId(author.getAuthor_id(), getAll()) &&
                authorControlService.controlAuthorNameSurnameUsed(author, getAll()) &&
                authorControlService.controlAuthorName(author) &&
                authorControlService.controlAuthorSurname(author)) {
            authorDao.update(author);
            System.out.println(author.getAuthor_id() + " id numaralı yazarın adı güncellendi");
        }
    }

    @Override
    public Author get(int author_id) {
        if (authorControlService.controlAuthorId(author_id, getAll())) {
            return authorDao.get(author_id);
        } else {
            System.out.println(author_id + " numaralı ID'ye sahip yazar bulunmuyor !");
            return null;
        }

    }

    @Override
    public List<Author> getAll() {
        return authorDao.getAll();
    }
}
