package dubovikLera.mapper;

import dubovikLera.dto.UserDto;
import dubovikLera.entity.User;


public class UserMapper implements Mapper<UserDto, User> {
    @Override
    public UserDto mapFrom(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getPersonalInfo().getName())
                .birthday(user.getPersonalInfo().getBirthday())
                .email(user.getEmail())
                .password(user.getPersonalInfo().getPassword())
                .role(user.getRole())
                .gender(user.getGender())
                .build();
    }

}