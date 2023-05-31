package dataAccess.concretes;

import dataAccess.abstracts.IAuthorDao;
import dataAccess.abstracts.IBookDao;
import dataAccess.abstracts.ICategoryDao;
import dataAccess.abstracts.IDbHelperDao;
import entities.concretes.Author;
import entities.concretes.Book;
import entities.concretes.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements IBookDao {
    private IDbHelperDao dbHelperDao;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet;
    ICategoryDao categoryDao;
    IAuthorDao authorDao;

    public BookDao(IDbHelperDao dbHelperDao) {
        this.dbHelperDao = dbHelperDao;
        authorDao = new AuthorDao(dbHelperDao);
        categoryDao = new CategoryDao(dbHelperDao);
    }

    @Override
    public void add(Book book) {
        Category category = categoryDao.get(book.getCategory_id());
        Author author = authorDao.get(book.getAuthor_id());
        try {
            String sql = "INSERT INTO tbl_books(category_id,category_name, author_id, author_name, book_name," +
                    " book_year, book_explanation, book_price)" +
                    "VALUES (?,?,?,?,?,?,?,?)";
            connection = dbHelperDao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getCategory_id());
            preparedStatement.setString(2, category.getCategory_name());
            preparedStatement.setInt(3, book.getAuthor_id());
            preparedStatement.setString(4, author.getAuthor_name() + " " + author.getAuthor_surname());
            preparedStatement.setString(5, book.getBook_name().toUpperCase());
            preparedStatement.setString(6, book.getBook_year());
            preparedStatement.setString(7, book.getBook_explanation().toUpperCase());
            preparedStatement.setDouble(8, book.getBook_price());
            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }
    }

    @Override
    public void delete(int book_id) {
        try {
            String sql = "DELETE FROM tbl_books WHERE book_id=?";
            connection = dbHelperDao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book_id);
            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }
    }

    @Override
    public void update(Book book) {
        try {
            String sql = "UPDATE tbl_books SET category_id=?, author_id=?, book_name=?, book_year=?, book_explanation=?," +
                    "book_price=? WHERE book_id";
            connection = dbHelperDao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getCategory_id());
            preparedStatement.setInt(2, book.getAuthor_id());
            preparedStatement.setString(3, book.getBook_name().toUpperCase());
            preparedStatement.setString(4, book.getBook_year());
            preparedStatement.setString(5, book.getBook_explanation().toUpperCase());
            preparedStatement.setDouble(6, book.getBook_price());
            preparedStatement.setInt(7, book.getBook_id());
            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }


    }

    @Override
    public Book get(int book_id) {
        for (Book book : getAll()) {
            if (book.getBook_id() == book_id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbl_books";
            connection = dbHelperDao.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            Book book;
            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt("book_id"), resultSet.getInt("category_id"),
                        resultSet.getInt("author_id"), resultSet.getString("book_name"),
                        resultSet.getString("book_explanation"), resultSet.getString("book_year"),
                        resultSet.getDouble("book_price")));

            }

        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }
        return books;
    }
}
