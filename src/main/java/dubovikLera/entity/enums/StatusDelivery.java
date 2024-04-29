package dubovikLera.entity.enums;

public enum StatusDelivery {
    СОБРАН("собран"),
    У_КУРЬЕРА("у курьера"),
    ЗАКАЗ_В_ПУТИ("заказ в пути"),
    ДОСТАВЛЕН("доставлен");

    private final String status;

    StatusDelivery(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}