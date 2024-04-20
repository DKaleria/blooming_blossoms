package dubovikLera.dao;

import dubovikLera.dto.ProductsDto;
import dubovikLera.entity.Customers;
import dubovikLera.entity.Favorites;
import dubovikLera.exception.DaoException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class FavoritesDao extends AbstractDao<Integer, Favorites> {
    @Getter
    private final static FavoritesDao INSTANCE = new FavoritesDao();

    private static final String GET_ALL_SQL = """
            select favorite_id, date_added, customer_id, product_id from favorites
            """;
    @Override
    protected Class<Favorites> getEntityClass() {
        return Favorites.class;
    }

    @Override
    protected String getEntityQuery() {
        return GET_ALL_SQL;
    }
}

