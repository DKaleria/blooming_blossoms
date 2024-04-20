package dubovikLera.service;

import dubovikLera.dao.CategoriesDao;
import dubovikLera.dto.CategoriesDto;
import dubovikLera.entity.Categories;

import java.util.List;
import java.util.Optional;

public class CategoriesService {
    private static final CategoriesService INSTANCE = new CategoriesService();
    private final CategoriesDao categoriesDao = CategoriesDao.getINSTANCE();

    public List<Categories> getAllCategories() {
        return categoriesDao.getAll();
    }

    public Optional<Categories> getCategoryById(int categoryId) {
        return categoriesDao.findById(categoryId);
    }

    public static CategoriesService getInstance() {
        return INSTANCE;
    }
}
