package dubovikLera.dao;

import dubovikLera.entity.Customers;
import dubovikLera.entity.Favorites;
import dubovikLera.entity.Products;
import dubovikLera.exception.DaoException;
import dubovikLera.utils.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FavoritesDao implements Dao<Integer, Favorites> {
    private final static FavoritesDao INSTANCE = new FavoritesDao();
    public static FavoritesDao getInstance(){
        return INSTANCE;
    }
    private FavoritesDao() {

    }

    private final static String UPDATE_SQL = """
            update favorites 
            set date_added = current_timestamp, customer_id = ?, product_id = ?
            where favorite_id = ?
            """;
    private static final String DELETE_SQL = """
            delete from favorites
            where favorite_id = ?
            """;

    private static final String GET_ALL_SQL = """
            select favorite_id, date_added, customer_id, product_id from favorites
            """;

    private static final String FIND_BY_ID_SQL = GET_ALL_SQL + """
            where favorite_id= ?
            """;

    private static final String CREATE_SQL = """
            insert into favorites
            values (date_added = ?, customer_id = ?, product_id = ?)
            """;



    @Override
    public void create(Favorites object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setTimestamp(1, object.getDate_added());
            statement.setInt(2, object.getCustomer_id().getCustomer_id());
            statement.setInt(3, object.getProduct_id().getProduct_id());




            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
    @Override
    public boolean update(Favorites object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(UPDATE_SQL)
        ) {

            statement.setInt(1, Integer.parseInt("customer_id"));
            statement.setInt(2, Integer.parseInt("product_id"));;
            statement.setInt(3, Integer.parseInt("favorite_id"));
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
    public List<Favorites> getAll() {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(GET_ALL_SQL)
        ) {
            List<Favorites> favoritesList = new ArrayList<>();

            var result = statement.executeQuery();
            while (result.next()) {
                int favoriteId = result.getInt("favorite_id");
                Timestamp dateAdded = result.getTimestamp("date_added");
                int customerId = result.getInt("customer_id");
                int productId = result.getInt("product_id");
                CustomersDao customersDao = CustomersDao.getInstance();
                Optional<Customers> customer = customersDao.findById(customerId);

                ProductsDao productsDao = ProductsDao.getInstance();
                Optional<Products> product = productsDao.findById(productId);

                if (customer.isPresent() && product.isPresent()) {
                    Favorites favorites = new Favorites(favoriteId, dateAdded, customer.get(), product.get());
                    favoritesList.add(favorites);
                }

            }
            return favoritesList;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }







    @Override
    public Optional<Favorites> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);
            var result = statement.executeQuery();


            if (result.next()) {
                Timestamp dateAdded = result.getTimestamp("date_added");
                int customerId = result.getInt("customer_id");
                int productId = result.getInt("product_id");

                CustomersDao customersDao = CustomersDao.getInstance();
                Optional<Customers> customer = customersDao.findById(customerId);

                ProductsDao productsDao = ProductsDao.getInstance();
                Optional<Products> product = productsDao.findById(productId);

                if (customer.isPresent() && product.isPresent()) {
                    Favorites favorites = new Favorites(id, dateAdded, customer.get(), product.get());
                    return Optional.of(favorites);
                }


            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }
}
