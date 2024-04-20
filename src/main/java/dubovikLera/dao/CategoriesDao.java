package dubovikLera.dao;

import dubovikLera.entity.Categories;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CategoriesDao extends AbstractDao<Integer, Categories> {
    @Getter
    private final static CategoriesDao INSTANCE = new CategoriesDao();
    private static final String GET_ALL_SQL = """
        select category_id, name from categories
        """;

    @Override
    protected Class<Categories> getEntityClass() {
        return Categories.class;
    }

    @Override
    protected String getEntityQuery() {
        return GET_ALL_SQL;
    }

}
