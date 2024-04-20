package dubovikLera.mapper;

import dubovikLera.dto.CreateUserDto;
import dubovikLera.entity.Gender;
import dubovikLera.entity.PersonalInfo;
import dubovikLera.entity.Role;
import dubovikLera.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateUserMapper implements Mapper<User, CreateUserDto> {
    @Getter
    private static final CreateUserMapper INSTANCE = new CreateUserMapper();
    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .personalInfo(PersonalInfo.builder()
                        .name(object.getName())
                        .birthday(LocalDate.parse(object.getBirthday()))
                        .password(object.getPassword())
                        .build())
                .email(object.getEmail())
                .role(Role.valueOf(object.getRole()))
                .gender(Gender.valueOf(object.getGender()))
                .build();
    }

}