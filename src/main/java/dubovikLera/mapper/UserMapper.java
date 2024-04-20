package dubovikLera.mapper;

import dubovikLera.dto.UserDto;
import dubovikLera.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper implements Mapper<UserDto, User> {
    @Getter
    private static final UserMapper INSTANCE = new UserMapper();

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