package dubovikLera.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PersonalInfo {
    @Column(nullable = false)
    private String name;
    @Column(name = "birthday",nullable = false)
    private LocalDate birthday;
    @Column(nullable = false)
    private String password;
}
