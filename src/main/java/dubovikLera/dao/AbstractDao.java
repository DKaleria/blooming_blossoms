package dubovikLera.dao;


import dubovikLera.entity.AbstractEntity;
import dubovikLera.entity.BaseEntity;
import dubovikLera.utils.SessionManager;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
public abstract class AbstractDao<K extends Serializable,E extends AbstractEntity<K>> implements Dao<K, E> {
    @Getter
    private final static SessionManager sessionManager = new SessionManager();

    private Class<E> clazz = getEntityClass();

    @Override
    public E save(E entity) {
        @Cleanup var session = sessionManager.openSession();
        session.save(entity);
        return entity;
    }

    @Override
    public void create(E object) {
        @Cleanup var session = sessionManager.openSession();
        session.save(object);
        session.flush();
    }

    @Override
    public void update(E object) {
        @Cleanup var session = sessionManager.openSession();
        session.merge(object);
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
        return session.createQuery(criteria).getResultList();
    }

    @Override
    public Optional<E> findById(K id) {
        @Cleanup var session = sessionManager.openSession();
        return Optional.ofNullable(session.find(clazz, id));
    }

    protected abstract Class<E> getEntityClass();
}
