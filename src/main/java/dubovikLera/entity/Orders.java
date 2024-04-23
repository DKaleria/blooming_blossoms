package dubovikLera.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = {"customer_id", "orderedProducts"})
@Table(name = "categories")
public class Orders extends AbstractEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @Column(nullable = false)
    private Timestamp order_date;

    @Column(name = "status_payment")
    @Enumerated(EnumType.STRING)
    private StatusPayment statusPayment;
    @Column(name = "status_delivery")
    @Enumerated(EnumType.STRING)
    private StatusDelivery statusDelivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customers customer_id;

    @Builder.Default
    @OneToMany(mappedBy = "order_id", fetch = FetchType.LAZY)
    private List<OrderedProducts> orderedProducts = new ArrayList<>();
}
