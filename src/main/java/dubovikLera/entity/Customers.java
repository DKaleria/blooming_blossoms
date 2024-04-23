package dubovikLera.entity;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = {"orders", "favorites"})
@Table(name = "customers")
public class Customers extends AbstractEntity<Integer> {
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
    @OneToMany(mappedBy = "customer_id", fetch = FetchType.LAZY)
    private List<Favorites> favorites = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "customer_id", fetch = FetchType.LAZY)
    private List<Orders> orders = new ArrayList<>();
}
