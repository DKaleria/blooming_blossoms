package dubovikLera.mapper;

import dubovikLera.dto.CreateUserDto;
import dubovikLera.entity.Gender;
import dubovikLera.entity.Role;
import dubovikLera.entity.User;


public class CreateUserMapper implements Mapper<User, CreateUserDto> {
    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .personalInfo(object.getPersonalInfo())
                .email(object.getEmail())
                .role(Role.valueOf(object.getRole()))
                .gender(Gender.valueOf(object.getGender()))
                .build();
    }

}