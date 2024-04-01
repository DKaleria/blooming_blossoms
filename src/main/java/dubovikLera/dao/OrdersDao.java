package dubovikLera.dao;

import dubovikLera.dto.ProductsDto;
import dubovikLera.entity.*;
import dubovikLera.exception.DaoException;
import dubovikLera.utils.ConnectionManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrdersDao implements Dao<Integer, Orders> {
    private final static OrdersDao INSTANCE = new OrdersDao();

    public static OrdersDao getInstance() {
        return INSTANCE;
    }

    private OrdersDao() {

    }

    private final static String UPDATE_SQL = """
            update orders
            set order_date = ?, status_payment = ?, status_delivery = ?, customer_id = ?
            where order_id = ?
            """;
    private static final String DELETE_SQL = """
            delete from orders
            where order_id = ?
            """;

    private static final String GET_ALL_SQL = """
            select order_id, order_date, status_payment, status_delivery, customer_id from orders
            """;

    private static final String FIND_BY_ID_SQL = GET_ALL_SQL + """
            where order_id = ?
            """;

    private static final String CREATE_SQL = """
            insert into orders
            values (order_date = ?, status_payment = ?, status_delivery = ? , customer_id = ?)
            """;


    @Override
    public void create(Orders object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setTimestamp(1, object.getOrder_date());
            statement.setObject(2, object.getStatusPayment());
            statement.setObject(3, object.getStatusDelivery());
            statement.setInt(4, object.getCustomer_id().getCustomer_id());


            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(Orders object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(UPDATE_SQL)
        ) {

            statement.setTimestamp(1, object.getOrder_date());
            statement.setString(2, object.getStatusPayment().toString());
            statement.setString(3, object.getStatusDelivery().toString());
            statement.setInt(4, object.getCustomer_id().getCustomer_id());
            statement.setInt(5, object.getOrder_id());
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
    public List<Orders> getAll() {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(GET_ALL_SQL)
        ) {
            List<Orders> ordersList = new ArrayList<>();

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
                    Orders orders = new Orders(orderId, orderDate, statusPayment, statusDelivery, customer.get());
                    ordersList.add(orders);
                }
            }
            return ordersList;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    @Override
    public Optional<Orders> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);
            var result = statement.executeQuery();

            Categories categories = null;
            if (result.next()) {
                Timestamp orderDate = result.getTimestamp("order_date");
                StatusPayment statusPayment = StatusPayment.valueOf(result.getString("status_payment"));
                StatusDelivery statusDelivery = StatusDelivery.valueOf(result.getString("status_delivery"));
                int customerId = result.getInt("customer_id");

                CustomersDao customersDao = CustomersDao.getInstance();
                Optional<Customers> customer = customersDao.findById(customerId);

                if (customer.isPresent()) {
                    Orders orders = new Orders(id, orderDate, statusPayment, statusDelivery, customer.get());
                    return Optional.of(orders);
                }
            }
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.empty();
    }
}
