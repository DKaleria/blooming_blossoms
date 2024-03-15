package dubovikLera.entity;

import java.util.Objects;

public class Customers {
    private Integer customer_id;
    private String first_name;
    private String last_name;
    private String delivery_address;
    private String contact_details;

    public Customers(Integer customer_id, String first_name, String last_name, String delivery_address, String contact_details) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.delivery_address = delivery_address;
        this.contact_details = contact_details;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getContact_details() {
        return contact_details;
    }

    public void setContact_details(String contact_details) {
        this.contact_details = contact_details;
    }

    @Override
    public String toString() {
        return "Customers{" +
               "customer_id=" + customer_id +
               ", first_name='" + first_name + '\'' +
               ", last_name='" + last_name + '\'' +
               ", delivery_address='" + delivery_address + '\'' +
               ", contact_details='" + contact_details + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return Objects.equals(customer_id, customers.customer_id) && Objects.equals(first_name, customers.first_name) && Objects.equals(last_name, customers.last_name) && Objects.equals(delivery_address, customers.delivery_address) && Objects.equals(contact_details, customers.contact_details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, first_name, last_name, delivery_address, contact_details);
    }
}
