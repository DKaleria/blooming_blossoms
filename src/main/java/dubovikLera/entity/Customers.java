package dubovikLera.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer customer_id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String delivery_address;
    @Column(nullable = false)
    private String contact_details;

    @Builder.Default
    @OneToMany(mappedBy = "customer_id")
    private List<Favorites> favorites = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "customer_id")
    private List<Orders> orders = new ArrayList<>();
}
