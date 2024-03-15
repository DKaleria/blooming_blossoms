package dubovikLera.entity;

import java.util.Objects;

public class Categories {
    private Integer category_id;
    private String name;

    public Categories(Integer category_id, String name) {
        this.category_id = category_id;
        this.name = name;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Categories{" +
               "category_id=" + category_id +
               ", name='" + name + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return Objects.equals(category_id, that.category_id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_id, name);
    }
}
