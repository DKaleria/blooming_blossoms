package dubovikLera.entity;

import dubovikLera.dto.ProductsDto;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = {"customer_id", "product_id"})
@Table(name = "categories")
public class Favorites extends AbstractEntity<Integer>{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer favorite_id;
    @Column(nullable = false)
    private Timestamp date_added;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customers customer_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Products product_id;
    public void setCustomers(Customers customers){
        this.customer_id = customers;
        customers.getFavorites().add(this);
    }

    public void setProducts(Products products){
        this.product_id = products;
        products.getFavorites().add(this);
    }

}
