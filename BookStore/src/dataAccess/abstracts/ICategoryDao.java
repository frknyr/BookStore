package dataAccess.abstracts;

import entities.concretes.Category;

import java.util.List;

public interface ICategoryDao {
    void add(Category Category);

    void update(Category Category);

    Category get(int id);

    List<Category> getAll();

}
