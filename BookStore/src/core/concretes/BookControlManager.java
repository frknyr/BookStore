package core.concretes;

import core.abstracts.IAuthorControlService;
import core.abstracts.IBookControlService;
import core.abstracts.ICategoryControlService;
import core.abstracts.ICustomerControlService;
import dataAccess.abstracts.IDbHelperDao;
import entities.concretes.Book;

import java.util.List;

public class BookControlManager implements IBookControlService {
    private IDbHelperDao dbHelperDao;
    ICustomerControlService customerControlService;
    IAuthorControlService authorControlService;
    ICategoryControlService categoryControlService;


    // Kitap adının uzunluğu kontrol ediliyor
    @Override
    public boolean controlBookName(Book book) {
        if (book.getBook_name().length() < 2) {
            return false;
        }
        return true;
    }

    // Kitap açıklamasının uzunlupu kontrol ediliyor
    @Override
    public boolean controlBookExplanation(Book book) {
        if (book.getBook_explanation().length() < 5) {
            return false;
        }
        return true;
    }

    // Girilen kitap fiyatı kontrol ediliyor
    @Override
    public boolean controlBookPrice(Book book) {
        if (book.getBook_price() < 0) {
            return false;
        }
        return true;
    }

    // Girilen ID'ye sahip kitabın olup olmadığı kontrol ediliyor
    @Override
    public boolean controlBookId(int book_id, List<Book> books) {
        for (Book book : books) {
            if (book.getBook_id() == book_id) {
                return true;
            }
        }
        return false;
    }


}
