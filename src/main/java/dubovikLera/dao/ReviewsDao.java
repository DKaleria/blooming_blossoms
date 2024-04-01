package dubovikLera.dao;


import dubovikLera.dto.ProductsDto;
import dubovikLera.entity.OrderedProducts;
import dubovikLera.entity.Orders;
import dubovikLera.entity.Reviews;
import dubovikLera.exception.DaoException;
import dubovikLera.utils.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewsDao implements Dao<Integer, Reviews> {
    private final static ReviewsDao INSTANCE = new ReviewsDao();

    public static ReviewsDao getInstance() {
        return INSTANCE;
    }

    private ReviewsDao() {

    }

    private final static String UPDATE_SQL = """
            update reviews
            set comment = ?, rating = ?, date = ?, orders_product_id = ?
            where review_id = ?
            """;
    private static final String DELETE_SQL = """
            delete from reviews
            where review_id = ?
            """;

    private static final String GET_ALL_SQL = """
            select review_id, comment, rating, date, orders_product_id from reviews
            """;

    private static final String FIND_BY_ID_SQL = GET_ALL_SQL + """
            where review_id = ?
            """;

    private static final String CREATE_SQL = """
            insert into reviews
            values (comment = ?, rating = ?, date = ?, orders_product_id = ?)
            """;


    private Reviews buildReview(ResultSet resultSet) throws SQLException {
        OrderedProductsDao orderedProductsDao = OrderedProductsDao.getInstance();
        Optional<OrderedProducts> orderedProduct = orderedProductsDao.findById(resultSet.getInt("orders_product_id"));

        if (orderedProduct.isPresent()) {
            return new Reviews(
                    resultSet.getInt("review_id"),
                    resultSet.getString("comment"),
                    resultSet.getBigDecimal("rating"),
                    resultSet.getTimestamp("date").toLocalDateTime(),
                    orderedProduct.get()
            );
        } else {
            throw new SQLException("Ordered Product not found for review.");
        }
    }

    @Override
    public void create(Reviews object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, object.getComment());
            statement.setBigDecimal(2, object.getRating());
            statement.setTimestamp(3, Timestamp.valueOf(object.getDate()));
            statement.setInt(4, object.getOrdered_product_id().getOrders_product_id());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public boolean update(Reviews object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(UPDATE_SQL)
        ) {

            statement.setString(1, object.getComment());
            statement.setBigDecimal(2, object.getRating());
            statement.setTimestamp(3, Timestamp.valueOf(object.getDate()));
            statement.setInt(4, object.getOrdered_product_id().getOrders_product_id());
            statement.setInt(5, object.getReview_id());
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Reviews> getAll() {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(GET_ALL_SQL)
        ) {
            List<Reviews> reviewsList = new ArrayList<>();


            var result = statement.executeQuery();
            while (result.next()) {
                Reviews review = buildReview(result);
                reviewsList.add(review);
            }
            return reviewsList;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Reviews> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);
            var result = statement.executeQuery();
            statement.setInt(1, id);

            if (result.next()) {
                Reviews review = buildReview(result);
                return Optional.of(review);


            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }
}
