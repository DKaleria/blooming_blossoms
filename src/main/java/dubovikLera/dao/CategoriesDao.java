package dubovikLera.dao;

import dubovikLera.entity.Categories;
import dubovikLera.exception.DaoException;
import dubovikLera.utils.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriesDao implements Dao<Integer, Categories> {
    private final static CategoriesDao INSTANCE = new CategoriesDao();


    public static CategoriesDao getInstance() {
        return INSTANCE;
    }

    private CategoriesDao() {

    }

    private final static String UPDATE_SQL = """
            update categories 
            set name = ?
            where category_id = ?
            """;
    private static final String DELETE_SQL = """
            delete from categories
            where category_id = ?
            """;

    private static final String GET_ALL_SQL = """
            select name from categories
            """;

    private static final String FIND_BY_ID_SQL = GET_ALL_SQL + """
            where category_id= ?
            """;

    private static final String CREATE_SQL = """
            insert into categories
            values (name = ?)
            """;

    private Categories buildCategories(ResultSet result) throws SQLException {
        return new Categories(
                result.getInt("category_id"),
                result.getString("name")
        );
    }


    @Override
    public void create(Categories object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, object.getName());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(Categories object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(UPDATE_SQL)
        ) {

            statement.setString(1, "name");
            statement.setInt(2, Integer.parseInt("category_id"));
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
    public List<Categories> getAll() {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(GET_ALL_SQL)
        ) {
            List<Categories> categories = new ArrayList<>();

            var result = statement.executeQuery();
            while (result.next()) {
                categories.add(buildCategories(result));
            }
            return categories;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Categories> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);
            var result = statement.executeQuery();

            Categories categories = null;
            if (result.next()) {
                categories = buildCategories(result);

            }

            return Optional.ofNullable(categories);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

}
