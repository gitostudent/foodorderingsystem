package models.orders.states;

public class FinishedState implements OrderState {

    public boolean isFinished() {
        return true;
    }

    public String message() {
        String message = "Order finished";
        return message;
    }
}
