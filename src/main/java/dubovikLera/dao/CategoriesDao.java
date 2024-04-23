package dubovikLera.dao;

import dubovikLera.entity.Categories;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CategoriesDao extends AbstractDao<Integer, Categories> {
    @Getter
    private final static CategoriesDao INSTANCE = new CategoriesDao();


    @Override
    protected Class<Categories> getEntityClass() {
        return Categories.class;
    }



}
