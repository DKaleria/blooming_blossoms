package dubovikLera.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Favorites {
    private Integer favorite_id;
    private Timestamp date_added;
    private Customers customer_id;
    private Products product_id;

    public Favorites(Integer favorite_id, Timestamp date_added, Customers customer_id, Products product_id) {
        this.favorite_id = favorite_id;
        this.date_added = date_added;
        this.customer_id = customer_id;
        this.product_id = product_id;
    }

    public Integer getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(Integer favorite_id) {
        this.favorite_id = favorite_id;
    }

    public Timestamp getDate_added() {
        return date_added;
    }

    public void setDate_added(Timestamp date_added) {
        this.date_added = date_added;
    }

    public Customers getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customers customer_id) {
        this.customer_id = customer_id;
    }

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "Favorites{" +
               "favorite_id=" + favorite_id +
               ", date_added=" + date_added +
               ", customer_id=" + customer_id +
               ", product_id=" + product_id +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorites favorites = (Favorites) o;
        return Objects.equals(favorite_id, favorites.favorite_id) && Objects.equals(date_added, favorites.date_added) && Objects.equals(customer_id, favorites.customer_id) && Objects.equals(product_id, favorites.product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(favorite_id, date_added, customer_id, product_id);
    }
}
