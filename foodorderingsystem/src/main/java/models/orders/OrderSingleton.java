package models.orders;

public class OrderSingleton {

    private int orderID = 0;
    private static OrderSingleton INSTANCE = new OrderSingleton();

    public static OrderSingleton getInstance() {
        return INSTANCE;
    }

    private OrderSingleton() {

    }

    public Order getOrder(int customerId) {
        ++orderID;
        return new Order(orderID, customerId);
    }
}
