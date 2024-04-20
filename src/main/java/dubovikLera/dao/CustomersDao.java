package dubovikLera.dao;


import dubovikLera.entity.Customers;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CustomersDao extends AbstractDao<Integer, Customers> {
    @Getter
    private final static CustomersDao INSTANCE = new CustomersDao();
    private static final String GET_ALL_SQL = """
            select customer_id, first_name, last_name, delivery_address, contact_details from customers
            """;

    @Override
    protected Class<Customers> getEntityClass() {
        return Customers.class;
    }

    @Override
    protected String getEntityQuery() {
        return GET_ALL_SQL;
    }

}
