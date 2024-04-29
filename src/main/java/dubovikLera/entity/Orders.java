package dubovikLera.entity;

import dubovikLera.entity.enums.StatusDelivery;
import dubovikLera.entity.enums.StatusPayment;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = {"customer_id", "orderedProducts"})
@Table(name = "orders")
public class Orders extends AbstractEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @Column(nullable = false)
    private Timestamp order_date;

    @Column(name = "status_payment")
    @Enumerated(EnumType.STRING)
    private StatusPayment status_payment;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_delivery")
    private StatusDelivery status_delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customers customer_id;

    @Builder.Default
    @OneToMany(mappedBy = "order_id", fetch = FetchType.LAZY)
    private List<OrderedProducts> ordered_products = new ArrayList<>();
}
