package dubovikLera.entity;

public enum StatusDelivery {
    COLLECTED("собран"),
    WITH_COURIER("у курьера"),
    IN_TRANSIT("заказ в пути"),
    DELIVERED("доставлен");

    private final String status;

    StatusDelivery(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
