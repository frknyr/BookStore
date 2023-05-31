package dataAccess.abstracts;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDbHelperDao {
    Connection getConnection() throws SQLException;

    void showErrorMessage(SQLException sqlException);
}
