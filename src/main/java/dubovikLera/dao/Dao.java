package dubovikLera.dao;

import dubovikLera.entity.Orders;

import java.util.List;
import java.util.Optional;

public interface Dao<K,E> {
    void create(E object);
    boolean update(E object);
    boolean delete(K id);
    List<E> getAll();
    Optional<E> findById(K id);

}
