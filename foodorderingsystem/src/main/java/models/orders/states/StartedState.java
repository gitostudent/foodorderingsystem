package models.orders.states;

public class StartedState implements OrderState {

    public boolean isFinished() {
        return false;
    }

    public String message() {
        String message = "Order canceled";
        return message;
    }
}
