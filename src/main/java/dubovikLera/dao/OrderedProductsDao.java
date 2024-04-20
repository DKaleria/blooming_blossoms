package dubovikLera.dao;

import dubovikLera.dto.ProductsDto;
import dubovikLera.entity.*;
import dubovikLera.exception.DaoException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class OrderedProductsDao extends AbstractDao<Integer, OrderedProducts> {
    @Getter
    private final static OrderedProductsDao INSTANCE = new OrderedProductsDao();

    private static final String GET_ALL_SQL = """
            select order_id, product_id, quantity, orders_product_id from ordered_products
            """;


    @Override
    protected Class<OrderedProducts> getEntityClass() {
        return OrderedProducts.class;
    }

    @Override
    protected String getEntityQuery() {
        return GET_ALL_SQL;
    }
}


