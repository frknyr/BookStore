package core.concretes;

import core.abstracts.ICategoryControlService;
import entities.concretes.Category;

import java.util.List;

public class CategoryControlManager implements ICategoryControlService {
    // Kategori adı kontrol ediliyor
    @Override
    public boolean controlCategoryName(Category category) {
        if (category.getCategory_name().length() < 2) {
            return false;
        }
        return true;
    }

    // Yeni kategori oluştururken, aynı ada sahip başka bir kategori var mı diye kontrol ediliyor
    @Override
    public boolean controlCategoryUsed(Category category, List<Category> categories) {
        for (Category controlCategory : categories) {
            if (controlCategory.getCategory_name().equals(category.getCategory_name().toUpperCase())) {
                return false;
            }
        }
        return true;
    }

    // Girilen ID'ye sahip kategori var mı diye kontrol ediliyor
    public boolean controlCategoryId(int category_id, List<Category> categories) {
        for (Category category : categories) {
            if (category.getCategory_id() == category_id) {
                return true;
            }
        }
        return false;
    }
}
