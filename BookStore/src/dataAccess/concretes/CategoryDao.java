package dataAccess.concretes;

import dataAccess.abstracts.ICategoryDao;
import dataAccess.abstracts.IDbHelperDao;
import entities.concretes.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements ICategoryDao {
    private IDbHelperDao dbHelper;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet;

    public CategoryDao(IDbHelperDao dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public void add(Category category) {
        try {
            String sql = "INSERT INTO TBL_CATEGORİES(CATEGORY_NAME) VALUES (?)";
            connection = dbHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getCategory_name().toUpperCase());
            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }

    }

    @Override
    public void update(Category category) {
        try {
            String sql = "UPDATE tbl_categories SET category_name=? WHERE category_id=?";
            connection = dbHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getCategory_name().toUpperCase());
            preparedStatement.setInt(2, category.getCategory_id());
            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }
    }

    @Override
    public Category get(int id) {
        for (Category category : getAll()) {
            if (category.getCategory_id() == id) {
                return category;
            }
        }
        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = null;
        try {
            String sql = "SELECT * FROM TBL_CATEGORİES";
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            categories = new ArrayList<Category>();

            while (resultSet.next()) {
                categories.add(new Category(resultSet.getInt("category_id"),
                        resultSet.getString("category_name")));
            }

            statement.close();
            connection.close();

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }

        return categories;
    }
}
