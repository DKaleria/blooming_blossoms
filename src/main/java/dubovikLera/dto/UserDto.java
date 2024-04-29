package dubovikLera.dto;

import dubovikLera.entity.enums.Gender;
import dubovikLera.entity.enums.Role;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDto {
    Integer id;
    String name;
    LocalDate birthday;
    String email;
    String password;
    Role role;
    Gender gender;
    boolean banned;
    boolean active;
}
