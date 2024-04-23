package dubovikLera.service;

import dubovikLera.dao.UserDao;
import dubovikLera.dto.CreateUserDto;
import dubovikLera.dto.UserDto;
import dubovikLera.exception.ValidationException;
import dubovikLera.mapper.CreateUserMapper;
import dubovikLera.mapper.UserMapper;
import lombok.NoArgsConstructor;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserMapper createUserMapper = new CreateUserMapper();
    private final UserDao userDao = UserDao.getINSTANCE();
    private final UserMapper userMapper = new UserMapper();

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password).map(userMapper::mapFrom);
    }

    public Integer create(CreateUserDto createUserDto) {
        var validationFactory = Validation.buildDefaultValidatorFactory();
        var validator = validationFactory.getValidator();
        var validationResult = validator.validate(createUserDto);

        if (!validationResult.isEmpty()) {
            throw new ConstraintViolationException(validationResult);
        }

        var userEntity = createUserMapper.mapFrom(createUserDto);
        return userDao.save(userEntity).getId();
    }

    public boolean delete(Integer id) {
        var maybeUser = userDao.findById(id);
        maybeUser.ifPresent(user -> userDao.delete(id));
        return maybeUser.isPresent();
    }

    public static UserService getINSTANCE() {
        return INSTANCE;
    }


}
