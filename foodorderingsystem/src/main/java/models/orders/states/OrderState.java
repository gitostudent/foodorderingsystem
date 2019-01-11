package models.orders.states;

public interface OrderState {
    boolean isFinished();
    String message();
}
