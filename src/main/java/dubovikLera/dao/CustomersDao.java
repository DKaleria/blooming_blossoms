package dubovikLera.dao;

import dubovikLera.entity.Customers;
import dubovikLera.entity.Orders;
import dubovikLera.exception.DaoException;
import dubovikLera.utils.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomersDao implements Dao<Integer,Customers> {
    private final static CustomersDao INSTANCE = new CustomersDao();

    private CustomersDao() {

    }
    private final static String UPDATE_SQL = """
    update customers 
    set first_name = ?, last_name = ?, delivery_address = ?, contact_details = ?
    where customer_id = ?
    """;
    private static final String DELETE_SQL ="""
    delete from customers
    where customer_id = ?
    """;

    private static final String GET_ALL_SQL =  """
    select customer_id, first_name, last_name, delivery_address, contact_details from customers
    """;

    private static final String FIND_BY_ID_SQL = GET_ALL_SQL + """
    where customer_id = ?
    """;
    private static final String CREATE_SQL = """
        insert into customers
        values (first_name = ?, last_name = ?, delivery_address = ?, contact_details = ?)
        """;



    private Customers buildCustomers(ResultSet result) throws SQLException {
        return new Customers(
                result.getInt("customer_id"),
                result.getString("first_name"),
                result.getString("last_name"),
                result.getString("delivery_address"),
                result.getString("contact_details")
        );
    }


    @Override
    public void create(Customers object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, object.getFirst_name());
            statement.setString(2, object.getLast_name());
            statement.setString(3, object.getDelivery_address());
            statement.setString(4, object.getContact_details());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
    @Override
    public boolean update(Customers object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(UPDATE_SQL)
        ) {

            statement.setString(1,"first_name");
            statement.setString(2,"last_name");
            statement.setString(3,"delivery_address");
            statement.setString(4,"contact_details");
            statement.setInt(5, Integer.parseInt("customer_id"));
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
    public List<Customers> getAll() {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(GET_ALL_SQL)
        ) {
            List<Customers> customers = new ArrayList<>();

            var result = statement.executeQuery();
            while (result.next()) {
                customers.add(buildCustomers(result));
            }
            return customers;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Customers> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);
            var result = statement.executeQuery();

            Customers customers = null;
            if (result.next()) {
                customers = buildCustomers(result);

            }

            return Optional.ofNullable(customers);
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }
    public static CustomersDao getInstance() {
        return INSTANCE;
    }
}