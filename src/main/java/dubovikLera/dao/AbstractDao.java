package dubovikLera.dao;


import dubovikLera.exception.DaoException;
import dubovikLera.utils.SessionManager;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.query.Query;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
public abstract class AbstractDao<K, T> implements Dao<K, T> {
    @Getter
    private final static SessionManager sessionManager = new SessionManager();

    @Override
    public void create(T object) {
        try (var session = sessionManager.openSession()) {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean update(T object) {
        try (var session = sessionManager.openSession()) {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(K id) {
        try (var session = sessionManager.openSession()) {
            session.beginTransaction();
            T entity = session.get(getEntityClass(), (Serializable) id);
            if (entity != null) {
                session.delete(entity);
                session.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<T> getAll() {
        try (var session = sessionManager.openSession()) {
            Query<T> query = session.createNativeQuery(getEntityQuery(), getEntityClass());
            return query.list();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<T> findById(K id) {
        try (var session = sessionManager.openSession()) {
            T entity = session.get(getEntityClass(), (Serializable) id);
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    protected abstract Class<T> getEntityClass();
    protected abstract String getEntityQuery();
}
