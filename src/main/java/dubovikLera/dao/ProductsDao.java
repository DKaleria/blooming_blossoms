package dubovikLera.dao;

import dubovikLera.dto.CategoriesDto;
import dubovikLera.dto.ProductsDto;
import dubovikLera.entity.Customers;
import dubovikLera.entity.Favorites;
import dubovikLera.entity.OrderedProducts;
import dubovikLera.entity.Products;
import dubovikLera.exception.DaoException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ProductsDao extends AbstractDao<Integer, Products> {
    @Getter
    private final static ProductsDao INSTANCE = new ProductsDao();
    @Override
    protected Class<Products> getEntityClass() {
        return Products.class;
    }
}
