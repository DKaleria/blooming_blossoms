package dubovikLera.dao;


import dubovikLera.entity.Favorites;
import dubovikLera.entity.OrderedProducts;
import dubovikLera.entity.Reviews;
import dubovikLera.exception.DaoException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ReviewsDao extends AbstractDao<Integer, Reviews> {
    @Getter
    private final static ReviewsDao INSTANCE = new ReviewsDao();

    public static ReviewsDao getInstance() {
        return INSTANCE;
    }

    private static final String GET_ALL_SQL = """
            select review_id, comment, rating, date, orders_product_id from reviews
            """;

    @Override
    protected Class<Reviews> getEntityClass() {
        return Reviews.class;
    }

    @Override
    protected String getEntityQuery() {
        return GET_ALL_SQL;
    }
}
