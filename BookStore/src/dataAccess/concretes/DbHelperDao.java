package dataAccess.concretes;

import dataAccess.abstracts.IDbHelperDao;

import java.sql.*;

public class DbHelperDao implements IDbHelperDao {
    private String username = "root";
    private String password = "12345";
    private String dbUrl = "jdbc:mysql://localhost:3306/book_store";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

    @Override
    public void showErrorMessage(SQLException sqlException) {
        System.out.println("Error: " + sqlException.getMessage());
        System.out.println("Error: " + sqlException.getErrorCode());
    }
}
