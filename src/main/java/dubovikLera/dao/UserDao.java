package dubovikLera.dao;

import dubovikLera.entity.Gender;
import dubovikLera.entity.Reviews;
import dubovikLera.entity.Role;
import dubovikLera.entity.User;
import dubovikLera.exception.DaoException;
import dubovikLera.utils.SessionManager;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.query.Query;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserDao extends AbstractDao<Long, User> {
    @Getter
    private static final UserDao INSTANCE = new UserDao();
    private static final String GET_ALL_SQL = "select * from users";
    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL =
            "select * from users where email = :email and password = :password";



    public Optional<User> findByEmailAndPassword(String email, String password) {
        try (var session = SessionManager.openSession()) {
            return session.createNativeQuery(GET_BY_EMAIL_AND_PASSWORD_SQL, User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public User save(User entity) {
        try (
                var session = SessionManager.openSession()
        ) {
            session.beginTransaction();

            session.save(entity);

            session.getTransaction().commit();
            return entity;
        } catch (DaoException e) {
            throw new DaoException(e);
        }
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected String getEntityQuery() {
        return GET_ALL_SQL;
    }
}
