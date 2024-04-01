package dubovikLera.service;

import dubovikLera.dao.CategoriesDao;
import dubovikLera.dto.CategoriesDto;

import java.util.List;
import java.util.Optional;

public class CategoriesService {
    private static final CategoriesService INSTANCE = new CategoriesService();
    private final CategoriesDao categoriesDao = CategoriesDao.getInstance();

    public List<CategoriesDto> getAllCategories() {
        return categoriesDao.getAll();
    }

    public Optional<CategoriesDto> getCategoryById(int categoryId) {
        return categoriesDao.findById(categoryId);
    }

    public static CategoriesService getInstance() {
        return INSTANCE;
    }
}
