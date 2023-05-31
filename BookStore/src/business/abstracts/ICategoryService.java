package business.abstracts;

import entities.concretes.Category;
import java.util.List;

public interface ICategoryService {
    void add(Category Category);

    void update(Category Category);

    Category get(int id);

    List<Category> getAll();
}
