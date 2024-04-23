package dubovikLera.dao;


import dubovikLera.entity.Customers;
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

    @Override
    protected Class<Reviews> getEntityClass() {
        return Reviews.class;
    }
}
