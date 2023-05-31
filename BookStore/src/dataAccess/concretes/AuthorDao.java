package dataAccess.concretes;

import dataAccess.abstracts.IAuthorDao;
import dataAccess.abstracts.IDbHelperDao;
import entities.concretes.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao implements IAuthorDao {
    private IDbHelperDao dbHelperDao;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet;

    public AuthorDao(IDbHelperDao dbHelperDao) {
        this.dbHelperDao = dbHelperDao;
    }

    @Override
    public void add(Author author) {
        try {
            String sql = "INSERT INTO tbl_authors(author_name,author_surname) VALUES (?,?)";
            connection = dbHelperDao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author.getAuthor_name());
            preparedStatement.setString(2, author.getAuthor_surname());
            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }
    }

    @Override
    public void delete(int author_id) {
        try {
            String sql = "DELETE FROM TBL_AUTHORS WHERE author_id=?";
            connection = dbHelperDao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, author_id);
            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }
    }

    @Override
    public void update(Author author) {
        try {
            String sql = "UPDATE TBL_AUTHORS SET author_name=?, author_surname=? WHERE author_id=?";
            connection = dbHelperDao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author.getAuthor_name());
            preparedStatement.setString(2, author.getAuthor_surname());
            preparedStatement.setInt(3, author.getAuthor_id());
            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }
    }

    @Override
    public Author get(int author_id) {
        for (Author author : getAll()) {
            if (author.getAuthor_id() == author_id) {
                return author;
            }
        }
        return null;
    }

    @Override
    public List<Author> getAll() {
        List<Author> authors = null;
        try {
            String sql = "SELECT * FROM tbl_authors";
            connection = dbHelperDao.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);


            authors = new ArrayList<>();
            while (resultSet.next()) {
                authors.add(new Author(resultSet.getInt("author_id"), resultSet.getString("author_name"),
                        resultSet.getString("author_surname")));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }
        return authors;
    }
}
