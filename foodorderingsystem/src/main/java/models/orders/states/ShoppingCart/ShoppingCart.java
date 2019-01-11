package models.orders.states.ShoppingCart;

import models.customers.Customer;
import models.orders.Order;
import models.orders.OrderSingleton;
import models.orders.payment.credentials.*;
import models.orders.payment.strategies.*;
import models.products.Product;

import java.util.Scanner;

public class ShoppingCart {

    Order order;
    Customer customer;

    Scanner scanner = new Scanner(System.in);

    public ShoppingCart(Customer customer) {
        this.customer = customer;
        order = createEmptyOrder();
    }

    private Order createEmptyOrder() {
        return OrderSingleton.getInstance().getOrder(customer.getId());
    }

    public void checkout() throws NoSuchStrategyException, NoSuchPaymentStrategyException {
        finishOrder();
        System.out.println("The total price is " + order.getTotalPrice());
        System.out.println("Choose your payment strategy: ");
        String paymentStrategy = scanner.nextLine();
        PaymentCredentials paymentCredentials = new PaymentCredentialsFactory().getPaymentCredentials(paymentStrategy);
        pay(new PaymentStrategyFactory().getPaymentStrategy(paymentStrategy, paymentCredentials));
    }

    private void pay(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(order.getTotalPrice());
    }

    public void addToOrder(Product food) {
        order.addToOrder(food);
    }

    public void removeFromOrder(Product food) {
        order.removeFromOrder(food);
    }

    private void finishOrder() {
        order.finishOrder();
    }

    private void cancelOrder() {
        order.cancelOrder();
    }

    public Order getOrder() {
        return this.order;
    }
}
