package models.orders;

import models.orders.states.FinishedState;
import models.orders.states.OrderState;
import models.orders.states.ShoppingCart.ShoppingCartVisitor;
import models.orders.states.StartedState;
import models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private int customerId;
    private double totalPrice;
    private List<Product> items;
    private ShoppingCartVisitor visitor;
    private OrderState state;

    public Order(int id, int customerId) {
        this.id = id;
        this.customerId = customerId;
        items = new ArrayList<Product>();
        visitor = new ShoppingCartVisitor();
        setState(new StartedState());
    }

    public void addToOrder(Product food) {
        this.items.add(food);
        this.totalPrice += food.accept(visitor);
    }

    public void removeFromOrder(Product food) {
        items.remove(food);
        this.totalPrice -= food.accept(visitor);
    }

    public double finishOrder() {
        setState(new FinishedState());
        return totalPrice;
    }

    public void cancelOrder() {
        setState(new StartedState());
    }

    private void setState(OrderState state) {
        this.state = state;
    }

    public OrderState getState() {
        return state;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getItems() {
        return items;
    }
}
