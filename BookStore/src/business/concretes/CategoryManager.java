package business.concretes;

import business.abstracts.ICategoryService;
import core.abstracts.ICategoryControlService;
import dataAccess.abstracts.ICategoryDao;
import entities.concretes.Category;
import java.util.List;

public class CategoryManager implements ICategoryService {
    private ICategoryDao categoryDao;
    private ICategoryControlService categoryControlService;

    public CategoryManager(ICategoryDao categoryDao, ICategoryControlService categoryControlService) {
        this.categoryDao = categoryDao;
        this.categoryControlService = categoryControlService;
    }

    @Override
    public void add(Category category) {
        if (categoryControlService.controlCategoryName(category)) {
            if (categoryControlService.controlCategoryUsed(category, getAll())) {
                categoryDao.add(category);
                System.out.println(category.getCategory_name().toUpperCase() + " adında yeni bir kategori oluşturuldu");
            } else {
                System.out.println(category.getCategory_name().toUpperCase() + " adında başka bir kategori  bulunuyor !");
            }
        } else {
            System.out.println("Kategori adı en az 2 karakterden oluşmalıdır !");
        }
    }

    @Override
    public void update(Category category) {
        if (categoryControlService.controlCategoryId(category.getCategory_id(), getAll())) {
            if (categoryControlService.controlCategoryName(category)) {
                if (categoryControlService.controlCategoryUsed(category, getAll())) {
                    categoryDao.update(category);
                    System.out.println("Kategori adı " + category.getCategory_name() + " olarak güncellendi");
                } else {
                    System.out.println(category.getCategory_name() + " adında başka bir kategori  bulunuyor !");
                }
            } else {
                System.out.println("Kategori adı en az 2 karakterli olmalıdır !");
            }
        } else {
            System.out.println(category.getCategory_id() + " numaralı ID'ye sahip kategori bulunmuyor !");
        }

    }

    @Override
    public Category get(int id) {
        if (categoryControlService.controlCategoryId(id, getAll())) {
            return categoryDao.get(id);

        } else {
            System.out.println(id + " numaralı ID'ye sahip kategori bulunmuyor !");
            return null;
        }
    }

    @Override
    public List<Category> getAll() {


        return categoryDao.getAll();
    }
}
