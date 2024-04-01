package dubovikLera.dao;

import dubovikLera.dto.CategoriesDto;
import dubovikLera.dto.ProductsDto;
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

public class ProductsDao implements Dao<Integer, ProductsDto> {
    private final static ProductsDao INSTANCE = new ProductsDao();

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

    private ProductsDto buildProduct(ResultSet result) throws SQLException {
        CategoriesDto categories = CategoriesDto.builder()
                .categoryId(result.getInt("category_id"))
                .name(result.getString("name"))
                .build();
        return ProductsDto.builder()
                .productId(result.getInt("product_id"))
                .name(result.getString("name"))
                .description(result.getString("description"))
                .price(result.getBigDecimal("price"))
                .availability(result.getBoolean("availability"))
                .image(result.getString("image"))
                .categories(categories)
                .quantityInStock(result.getInt("quantity_in_stock"))
                .build();
    }

    @Override
    public void create(ProductsDto object) {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, object.getName());
            statement.setString(2, object.getDescription());
            statement.setBigDecimal(3, object.getPrice());
            statement.setBoolean(4, object.isAvailability());
            statement.setString(5, object.getImage());
            statement.setInt(6, object.getCategories().getCategoryId());
            statement.setInt(7, object.getQuantityInStock());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(ProductsDto object) {

        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(UPDATE_SQL)
        ) {
            statement.setString(1, object.getName());
            statement.setString(2, object.getDescription());
            statement.setBigDecimal(3, object.getPrice());
            statement.setBoolean(4, object.isAvailability());
            statement.setString(5, object.getImage());
            statement.setInt(6, object.getCategories().getCategoryId());
            statement.setInt(7, object.getQuantityInStock());
            statement.setInt(8, object.getProductId());
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
    public List<ProductsDto> getAll() {
        try (
                var connection = ConnectionManager.get();
                var statement = connection.prepareStatement(GET_ALL_SQL)
        ) {
            List<ProductsDto> productsList = new ArrayList<>();

            var result = statement.executeQuery();
            while (result.next()) {
                ProductsDto product = buildProduct(result);
                productsList.add(product);
            }
            return productsList;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    @Override
    public Optional<ProductsDto> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);
            var result = statement.executeQuery();

            if (result.next()) {
                ProductsDto product = buildProduct(result);
                return Optional.of(product);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.empty();
    }


    public static ProductsDao getInstance() {
        return INSTANCE;
    }
}
