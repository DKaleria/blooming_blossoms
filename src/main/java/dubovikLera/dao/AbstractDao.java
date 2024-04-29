package dubovikLera.dao;


import dubovikLera.entity.AbstractEntity;
import dubovikLera.entity.BaseEntity;
import dubovikLera.entity.Orders;
import dubovikLera.entity.Products;
import dubovikLera.entity.enums.StatusDelivery;
import dubovikLera.exception.DaoException;
import dubovikLera.utils.SessionManager;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
public abstract class AbstractDao<K extends Serializable, E extends AbstractEntity<K>> implements Dao<K, E> {
    @Getter
    private final static SessionManager sessionManager = new SessionManager();

    private Class<E> clazz = getEntityClass();

    @Override
    public E save(E entity) {
        try (Session session = sessionManager.openSession()) {
            session.doWork(connection -> {
                try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO orders (status_delivery) VALUES (?)")) {
                    // Приведение значения перечисления к типу status_delivery
                    Object statusDeliveryValue = connection.createArrayOf(
                            "status_delivery", new Object[]{((Orders) entity).getStatus_delivery().getStatus()});
                    statement.setObject(1, statusDeliveryValue);

                    statement.executeUpdate();
                }
            });

            session.saveOrUpdate(entity);
            return entity;
        } catch (Exception e) {
            // Обработка ошибки
            e.printStackTrace();
            throw new DaoException(e);
        }
    }
    @Override
    public void create(E object) {
        try (Session session = sessionManager.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(object);
            session.flush();
            transaction.commit();
        }
    }

    @Override
    public void update(E object) {
        try (Session session = sessionManager.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        }
    }

    @Override
    public void delete(K id) {
        @Cleanup var session = sessionManager.openSession();
        session.delete(id);
        session.flush();
    }

    @Override
    public List<E> getAll() {
        @Cleanup var session = sessionManager.openSession();
        var criteria = session.getCriteriaBuilder().createQuery(clazz);
        criteria.from(clazz);
        List<E> resultList = session.createQuery(criteria).getResultList();
        return resultList;

    }

    public Optional<E> findById(K id) {
        @Cleanup var session = sessionManager.openSession();
        E entity = session.find(clazz, id);
        return Optional.ofNullable(entity);
    }


    protected abstract Class<E> getEntityClass();

    public List<Products> getProductsByCategoryId(int categoryId) {
        @Cleanup var session = sessionManager.openSession();
        var criteriaBuilder = session.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Products.class);
        var root = criteriaQuery.from(Products.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("category_id"), categoryId));
        List<Products> resultList = session.createQuery(criteriaQuery).getResultList();
        return resultList;
    }
}
