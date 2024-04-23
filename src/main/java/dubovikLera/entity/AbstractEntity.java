package dubovikLera.entity;

import java.io.Serializable;

public abstract class AbstractEntity<T extends Serializable> implements BaseEntity<T> {
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}