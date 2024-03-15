package dubovikLera.entity;

public enum StatusPayment {
    EXPOSED("выставлен"),
    DELETED("удален"),
    IN_PAYMENT("в оплате"),
    OVERDUE("просрочен"),
    PAID("оплачен"),
    CANCELED("отменен"),
    PARTIALLY_CANCELED("отменен частично");

    private final String status;

    StatusPayment(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}