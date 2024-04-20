package dubovikLera.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "categories")
public class Orders {
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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer_id;

    @Builder.Default
    @OneToMany(mappedBy = "order_id")
    private List<OrderedProducts> orderedProducts = new ArrayList<>();
}
