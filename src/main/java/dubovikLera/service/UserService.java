package dubovikLera.service;

import dubovikLera.dao.UserDao;
import dubovikLera.dto.CreateUserDto;
import dubovikLera.dto.UserDto;
import dubovikLera.entity.enums.Role;
import dubovikLera.entity.User;
import dubovikLera.mapper.CreateUserMapper;
import dubovikLera.mapper.UserMapper;
import dubovikLera.utils.validation.ValidationManager;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {
    @Getter
    private static final UserService INSTANCE = new UserService();
    private final CreateUserMapper createUserMapper = new CreateUserMapper();
    private final UserDao userDao = UserDao.getINSTANCE();
    private final UserMapper userMapper = new UserMapper();
    private final ValidationManager<CreateUserDto> validationManager = new ValidationManager();

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password).map(userMapper::mapFrom);
    }

    public Integer create(CreateUserDto createUserDto) {
        validationManager.validate(createUserDto);

        var userEntity = createUserMapper.mapFrom(createUserDto);
        return userDao.save(userEntity).getId();
    }
    public void banUser(Integer userId) {
        Optional<User> optionalUser = userDao.findById(userId);
        System.out.println("Is user present? " + optionalUser.isPresent());
        optionalUser.ifPresent(user -> {
            user.setBanned(true);
            user.setActive(false);
            userDao.update(user);
        });
    }
    public void changeUserRole(Integer userId, Role newRole) {
        Optional<User> optionalUser = userDao.findById(userId);
          if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setRole(newRole);
            userDao.update(user);
            System.out.println("User role changed successfully");
        } else {
            System.out.println("User not found");
        }
    }
    public List<User> getAllUsers() {
        return userDao.getAll();
    }
       public void unlockUser(int userId) {
        Optional<User> optionalUser = userDao.findById(userId);
        System.out.println("Is user present? " + optionalUser.isPresent());
        optionalUser.ifPresent(user -> {
            user.setBanned(false);
            user.setActive(true);
            userDao.update(user);
        });

    }
    public void updateUser(User user) {
        userDao.update(user);
    }
    public boolean delete(Integer id) {
        var maybeUser = userDao.findById(id);
        maybeUser.ifPresent(user -> userDao.delete(id));
        return maybeUser.isPresent();
    }

    public Optional<User> getUserById(Integer userId) {
        return userDao.findById(userId);
    }
}