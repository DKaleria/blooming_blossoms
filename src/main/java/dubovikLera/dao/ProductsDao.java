package dubovikLera.dao;

import dubovikLera.dto.CategoriesDto;
import dubovikLera.dto.ProductsDto;
import dubovikLera.entity.Favorites;
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
    private static final String GET_ALL_SQL = """
            select product_id, name, description, price, availability, image, category_id, quantity_in_stock from products
            """;

    @Override
    protected Class<Products> getEntityClass() {
        return Products.class;
    }

    @Override
    protected String getEntityQuery() {
        return GET_ALL_SQL;
    }
}
