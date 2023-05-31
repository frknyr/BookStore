package business.concretes;

import business.abstracts.IBookService;
import core.abstracts.IBookControlService;
import dataAccess.abstracts.IBookDao;
import entities.concretes.Book;

import java.util.List;

public class BookManager implements IBookService {
    private IBookDao bookDao;
    private IBookControlService bookControlService;

    public BookManager(IBookDao bookDao, IBookControlService bookControlService) {
        this.bookDao = bookDao;
        this.bookControlService = bookControlService;
    }

    @Override
    public void add(Book book) {
        // Kontrol sistemleri
        bookDao.add(book);
    }

    @Override
    public void delete(int book_id) {
        if (bookControlService.controlBookId(book_id, getAll())) {
            bookDao.delete(book_id);
            System.out.println(book_id + " numaralı kitap silindi");
        } else {
            System.out.println(book_id + " numaralı ID'ye sahip kitap bulunmuyor !");
        }

    }

    @Override
    public void update(Book book) {
        // Kontrol sistemleri
        bookDao.update(book);
    }

    @Override
    public Book get(int book_id) {
        if (bookControlService.controlBookId(book_id, getAll())) {
            return bookDao.get(book_id);
        } else {
            System.out.println(book_id + " numaralı ID'ye sahip kitap bulunmuyor !");
            return null;
        }
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
