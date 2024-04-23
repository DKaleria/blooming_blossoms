package dubovikLera.dao;


import dubovikLera.entity.Categories;
import dubovikLera.entity.Customers;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CustomersDao extends AbstractDao<Integer, Customers> {
    @Getter
    private final static CustomersDao INSTANCE = new CustomersDao();
    @Override
    protected Class<Customers> getEntityClass() {
        return Customers.class;
    }


}
