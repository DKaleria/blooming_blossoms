package dubovikLera.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Orders {
    private Integer order_id;
    private Timestamp order_date;
    private StatusPayment statusPayment;
    private StatusDelivery statusDelivery;
    private Customers customer_id;

    public Orders(Integer order_id, Timestamp order_date, StatusPayment statusPayment, StatusDelivery statusDelivery, Customers customer_id) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.statusPayment = statusPayment;
        this.statusDelivery = statusDelivery;
        this.customer_id = customer_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public StatusPayment getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(StatusPayment statusPayment) {
        this.statusPayment = statusPayment;
    }

    public StatusDelivery getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(StatusDelivery statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public Customers getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customers customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Orders{" +
               "order_id=" + order_id +
               ", order_date=" + order_date +
               ", statusPayment=" + statusPayment +
               ", statusDelivery=" + statusDelivery +
               ", customer_id=" + customer_id +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(order_id, orders.order_id) && Objects.equals(order_date, orders.order_date) && statusPayment == orders.statusPayment && statusDelivery == orders.statusDelivery && Objects.equals(customer_id, orders.customer_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, order_date, statusPayment, statusDelivery, customer_id);
    }
}
