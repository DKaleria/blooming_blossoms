package dubovikLera.dto;

import dubovikLera.entity.PersonalInfo;
import lombok.Builder;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
@Builder
public class CreateUserDto {
    @Valid
    PersonalInfo personalInfo;
    @NotNull
    @NotEmpty
    String email;
    @NotNull
    @NotEmpty
    String role;
    @NotNull
    @NotEmpty
    String gender;
}
