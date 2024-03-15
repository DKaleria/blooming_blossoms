package dubovikLera.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Products {
    private Integer product_id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean availability;
    private String image;
    private Categories category_id;
    private Integer quantity_in_stock;

    public Products(Integer product_id, String name, String description, BigDecimal price, Boolean availability, String image, Categories category_id, Integer quantity_in_stock) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.availability = availability;
        this.image = image;
        this.category_id = category_id;
        this.quantity_in_stock = quantity_in_stock;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Categories getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Categories category_id) {
        this.category_id = category_id;
    }

    public Integer getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public void setQuantity_in_stock(Integer quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    @Override
    public String toString() {
        return "Products{" +
               "product_id=" + product_id +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", price=" + price +
               ", availability=" + availability +
               ", image='" + image + '\'' +
               ", category_id=" + category_id +
               ", quantity_in_stock=" + quantity_in_stock +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(product_id, products.product_id) && Objects.equals(name, products.name) && Objects.equals(description, products.description) && Objects.equals(price, products.price) && Objects.equals(availability, products.availability) && Objects.equals(image, products.image) && Objects.equals(category_id, products.category_id) && Objects.equals(quantity_in_stock, products.quantity_in_stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, name, description, price, availability, image, category_id, quantity_in_stock);
    }
}
