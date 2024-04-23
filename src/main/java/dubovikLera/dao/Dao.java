package dubovikLera.dao;

import dubovikLera.entity.AbstractEntity;
import dubovikLera.entity.Orders;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Dao<K extends Serializable,E extends AbstractEntity<K>> {

    E save(E entity);
    void create(E object);
    void update(E object);
    void delete(K id);
    List<E> getAll();
    Optional<E> findById(K id);

}
