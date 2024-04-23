package dubovikLera.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PersonalInfo {
    @Column(nullable = false)
    @NotNull(message = "Name must not be null")
    private String name;
    @Column(name = "birthday", nullable = false)

    @NotNull(message = "Birthday must not be null")
    private LocalDate birthday;

    @Column(nullable = false)
    @NotNull(message = "Password must not be null")
    private String password;
}
