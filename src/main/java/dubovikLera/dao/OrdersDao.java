package dubovikLera.dao;

import dubovikLera.entity.*;
import dubovikLera.exception.DaoException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class OrdersDao extends AbstractDao<Integer, Orders> {
    @Getter
    private final static OrdersDao INSTANCE = new OrdersDao();
    @Override
    protected Class<Orders> getEntityClass() {
        return Orders.class;
    }

}
