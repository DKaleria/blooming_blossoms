package dubovikLera.dao;

import dubovikLera.entity.*;
import dubovikLera.exception.DaoException;
import dubovikLera.utils.SessionManager;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserDao extends AbstractDao<Integer, User> {
    @Getter
    private static final UserDao INSTANCE = new UserDao();
    public Optional<User> findByEmailAndPassword(String email, String password) {
        var session = SessionManager.openSession();
        Query<User> query = session.createQuery("select u from User u where u.email = :email and u.personalInfo.password = :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> resultList = query.getResultList();
        return resultList.stream().findFirst();
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
