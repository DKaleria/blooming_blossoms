package dubovikLera.service;

import dubovikLera.dao.CategoriesDao;
import dubovikLera.dao.ProductsDao;
import dubovikLera.dto.ProductsDto;
import dubovikLera.entity.Products;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ProductsService {
    private static final ProductsService INSTANCE = new ProductsService();
    private final ProductsDao productsDao = ProductsDao.getINSTANCE();
    private final CategoriesDao categoriesDao = CategoriesDao.getINSTANCE();


    public List<Products> getAllProducts() {
        return productsDao.getAll();
    }

    public List<Products> getProductsByCategory(int categoryId) {
        return productsDao.findById(categoryId)
                .map(Collections::singletonList)
                .orElse(Collections.emptyList());
    }
    public static ProductsService getInstance() {
        return INSTANCE;
    }


}