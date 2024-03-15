package dubovikLera.dao;

import dubovikLera.entity.*;
import dubovikLera.exception.DaoException;
import dubovikLera.utils.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsDao implements Dao<Integer,Products> {
    private final static ProductsDao INSTANCE = new ProductsDao();
    public static ProductsDao getInstance(){
        return INSTANCE;
    }
    private ProductsDao() {

    }
    private final static String UPDATE_SQL = """
            update products
            set name = ?, description = ?, price = ?, availability = ?, image = ?, category_id = ?, quantity_in_stock = ?
            where product_id = ?
            """;
    private static final String DELETE_SQL = """
            delete from products
            where product_id = ?
            """;

    private static final String GET_ALL_SQL = """
            select product_id, name, description, price, availability, image, category_id, quantity_in_stock from products
            """;

    private static final String FIND_BY_ID_SQL = GET_ALL_SQL + """
            where product_id = ?
            """;

    private static final String CREATE_SQL = """
            insert into products
            values (name = ?, description = ?, price = ?, availability = ?,
            image = ?, category_id = ?, quantity_in_stock = ?)
            """;
    private Products buildProduct(ResultSet result) throws SQLException {
        Categories categories = new Categories( result.getInt("category_id"),
                result.getString("name")
        );
        return new Products(
                result.getInt("product_id"),
                result.getString("name"),
                result.getString("description"),
                result.getBigDecimal("price"),
                result.getBoolean("availability"),
                result.getString("image"),
                categories,
                result.getInt("quantity_in_stock")
        );
    }


    @Override
    public void create(Products object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, object.getName());
            statement.setString(2, object.getDescription());
            statement.setBigDecimal(3, object.getPrice());
            statement.setBoolean(4, object.getAvailability());
            statement.setString(5, object.getImage());
            statement.setInt(6, object.getCategory_id().getCategory_id());
            statement.setInt(7, object.getQuantity_in_stock());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(Products object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(UPDATE_SQL)
        ) {
            statement.setString(1, object.getName());
            statement.setString(2, object.getDescription());
            statement.setBigDecimal(3, object.getPrice());
            statement.setBoolean(4, object.getAvailability());
            statement.setString(5, object.getImage());
            statement.setInt(6, object.getCategory_id().getCategory_id());
            statement.setInt(7, object.getQuantity_in_stock());
            statement.setInt(8, object.getProduct_id());    return statement.executeUpdate() > 0;

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
    public List<Products> getAll() {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(GET_ALL_SQL)
        ) {
            List<Products> productsList = new ArrayList<>();

            var result = statement.executeQuery();
            while (result.next()) {
                int orderId = result.getInt("order_id");
                Timestamp orderDate = result.getTimestamp("order_date");
                StatusPayment statusPayment = StatusPayment.valueOf(result.getString("status_payment"));
                StatusDelivery statusDelivery = StatusDelivery.valueOf(result.getString("status_delivery"));
                int customerId = result.getInt("customer_id");

                CustomersDao customersDao = CustomersDao.getInstance();
                Optional<Customers> customer = customersDao.findById(customerId);

                if (customer.isPresent()) {
                    Products product = buildProduct(result);
                    productsList.add(product); }
            }
            return productsList;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Products> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);
            var result = statement.executeQuery();

            if (result.next()) {
                Products product = buildProduct(result);
                return Optional.of(product);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.empty();
    }
}
