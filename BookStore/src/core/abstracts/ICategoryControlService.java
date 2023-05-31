package core.abstracts;

import entities.concretes.Category;

import java.util.List;

public interface ICategoryControlService {
    boolean controlCategoryName(Category category);

    boolean controlCategoryUsed(Category category, List<Category> categories);

    boolean controlCategoryId(int category_id, List<Category> categories);

}
