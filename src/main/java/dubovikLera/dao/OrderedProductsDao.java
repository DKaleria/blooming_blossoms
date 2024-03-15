package dubovikLera.dao;

import dubovikLera.entity.Categories;
import dubovikLera.entity.OrderedProducts;
import dubovikLera.entity.Orders;
import dubovikLera.entity.Products;
import dubovikLera.exception.DaoException;
import dubovikLera.utils.ConnectionManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderedProductsDao implements Dao<Integer, OrderedProducts> {
    private final static OrderedProductsDao INSTANCE = new OrderedProductsDao();

    public static OrderedProductsDao getInstance() {
        return INSTANCE;
    }

    private OrderedProductsDao() {

    }

    private final static String UPDATE_SQL = """
            update ordered_products
            set order_id = ?, product_id = ?, quantity = ?
            where orders_product_id = ?
            """;
    private static final String DELETE_SQL = """
            delete from ordered_products
            where orders_product_id = ?
            """;

    private static final String GET_ALL_SQL = """
            select order_id, product_id, quantity, orders_product_id from ordered_products
            """;

    private static final String FIND_BY_ID_SQL = GET_ALL_SQL + """
            where orders_product_id = ?
            """;

    private static final String CREATE_SQL = """
            insert into ordered_products
            values (order_id = ?, product_id = ?, quantity = ?)
            """;


    @Override
    public void create(OrderedProducts object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setInt(1, object.getOrder_id().getOrder_id());
            statement.setInt(2, object.getProduct_id().getProduct_id());
            statement.setInt(3, object.getQuantity());


            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(OrderedProducts object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(UPDATE_SQL)
        ) {

            statement.setInt(1, object.getOrder_id().getOrder_id());
            statement.setInt(2, object.getProduct_id().getProduct_id());
            statement.setInt(3, object.getQuantity());
            statement.setInt(4, object.getOrders_product_id());
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
    public List<OrderedProducts> getAll() {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(GET_ALL_SQL)
        ) {
            List<OrderedProducts> orderedProductsList = new ArrayList<>();

            var result = statement.executeQuery();
            while (result.next()) {
                int orderId = result.getInt("order_id");
                int productId = result.getInt("product_id");
                int quantity = result.getInt("quantity");
                int ordersProductId = result.getInt("orders_product_id");

                OrdersDao ordersDao = OrdersDao.getInstance();
                Optional<Orders> order = ordersDao.findById(orderId);

                ProductsDao productsDao = ProductsDao.getInstance();
                Optional<Products> product = productsDao.findById(productId);

                if (order.isPresent() && product.isPresent()) {
                    OrderedProducts orderedProducts = new OrderedProducts(order.get(), product.get(),
                            quantity, ordersProductId);
                    orderedProductsList.add(orderedProducts);
                }
            }
            return orderedProductsList;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<OrderedProducts> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);
            var result = statement.executeQuery();

            Categories categories = null;
            if (result.next()) {
                int orderId = result.getInt("order_id");
                int productId = result.getInt("product_id");
                int quantity = result.getInt("quantity");

                OrdersDao ordersDao = OrdersDao.getInstance();
                Optional<Orders> order = ordersDao.findById(orderId);

                ProductsDao productsDao = ProductsDao.getInstance();
                Optional<Products> product = productsDao.findById(productId);

                if (order.isPresent() && product.isPresent()) {
                    OrderedProducts orderedProducts = new OrderedProducts(order.get(), product.get(),
                            quantity, id);
                    return Optional.of(orderedProducts);

                }
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }
}
