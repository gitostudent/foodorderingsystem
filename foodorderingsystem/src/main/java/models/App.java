package models;

import models.customers.Customer;
import models.customers.FacadeCustomer;
import models.orders.payment.credentials.NoSuchStrategyException;
import models.orders.payment.strategies.NoSuchPaymentStrategyException;
import models.orders.states.ShoppingCart.ShoppingCart;
import models.products.Product;
import models.products.ProductFactory;

public class App {
    public static void main(String[] args) throws NoSuchStrategyException, NoSuchPaymentStrategyException {
        Customer customer = FacadeCustomer.getInstance().getCustomer("Adam", "Marek", "Mickiewicz");
        ShoppingCart shoppingCart = new ShoppingCart(customer);
        ProductFactory productFactory = new ProductFactory();
        Product pizza1 = productFactory.getProduct(1, "pizza1", 10.0, 1);
        Product pizza2 = productFactory.getProduct(2, "pizza2", 12.0, 1);
        Product cocacola = productFactory.getProduct(3, "coca-cola", 3.0, 2);
        shoppingCart.addToOrder(pizza1);
        shoppingCart.addToOrder(pizza2);
        shoppingCart.addToOrder(cocacola);
        shoppingCart.removeFromOrder(cocacola);
        shoppingCart.checkout();
    }
}
