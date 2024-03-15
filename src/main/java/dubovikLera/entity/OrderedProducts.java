package dubovikLera.entity;

import java.util.Objects;

public class OrderedProducts {
    private Orders order_id;
    private Products product_id;
    private Integer quantity;
    private Integer orders_product_id;

    public OrderedProducts(Orders order_id, Products product_id, Integer quantity, Integer orders_product_id) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.orders_product_id = orders_product_id;
    }

    public Orders getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Orders order_id) {
        this.order_id = order_id;
    }

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrders_product_id() {
        return orders_product_id;
    }

    public void setOrders_product_id(Integer orders_product_id) {
        this.orders_product_id = orders_product_id;
    }

    @Override
    public String toString() {
        return "Ordered_products{" +
               "order_id=" + order_id +
               ", product_id=" + product_id +
               ", quantity=" + quantity +
               ", orders_product_id=" + orders_product_id +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedProducts that = (OrderedProducts) o;
        return Objects.equals(order_id, that.order_id) && Objects.equals(product_id, that.product_id) && Objects.equals(quantity, that.quantity) && Objects.equals(orders_product_id, that.orders_product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, product_id, quantity, orders_product_id);
    }
}
