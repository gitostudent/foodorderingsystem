package models;

import models.customers.Customer;
import models.customers.FacadeCustomer;
import models.orders.payment.credentials.NoSuchStrategyException;
import models.orders.payment.strategies.NoSuchPaymentStrategyException;
import models.orders.states.ShoppingCart.ShoppingCart;
import models.products.*;
import models.products.Food.Category;
import models.products.Food.Component;

public class App {
    public static void main(String[] args) throws NoSuchStrategyException, NoSuchPaymentStrategyException {


        //Tworzymy poczatkowy Cennik
        PriceComponent cennik=new PriceComponent();
        cennik.setPrice(new Component("cienkie", true, Category.DOUGHT),5.0);
        cennik.setPrice(new Component("grube", true, Category.DOUGHT),6.0);
        cennik.setPrice(new Component("gluten-free", true, Category.DOUGHT),7.0);

        cennik.setPrice(new Component("chedar", true, Category.CHESEE),3.0);
        cennik.setPrice(new Component("gouda", true, Category.CHESEE),4.5);

        cennik.setPrice(new Component("szynka", false, Category.TOPLING),2.);
        cennik.setPrice(new Component("boczek", false, Category.TOPLING),2.);
        cennik.setPrice(new Component("kielbasa", false, Category.TOPLING),2);
        cennik.setPrice(new Component("cebula", true, Category.TOPLING),1.);
        cennik.setPrice(new Component("oliwki", true, Category.TOPLING),1.);
        cennik.setPrice(new Component("pomidor", true, Category.TOPLING),1.);


        //Tworzymy testowy poczatkowy magazyn na skladniki do pizzy
        IStoreHandler store= new StoreRoom(cennik);
        store.addComponent(new Component("cienkie", true, Category.DOUGHT));
        store.addComponent(new Component("cienkie", true, Category.DOUGHT));
        store.addComponent(new Component("grube", true, Category.DOUGHT));
        store.addComponent(new Component("gluten-free", true, Category.DOUGHT));

        store.addComponent(new Component("chedar", true, Category.CHESEE));
        store.addComponent(new Component("gouda", true, Category.CHESEE));

        store.addComponent(new Component("szynka", false, Category.TOPLING));
        store.addComponent(new Component("boczek", false, Category.TOPLING));
        store.addComponent(new Component("oliwki", true, Category.TOPLING));
        store.addComponent(new Component("cebula", true, Category.TOPLING));
        store.addComponent(new Component("boczek", false, Category.TOPLING));
        store.addComponent(new Component("oliwki", true, Category.TOPLING));
        store.addComponent(new Component("cebula", true, Category.TOPLING));
        store.addComponent(new Component("boczek", false, Category.TOPLING));




        Customer customer = FacadeCustomer.getInstance().getCustomer("Adam", "Marek", "Mickiewicz");
        ShoppingCart shoppingCart = new ShoppingCart(customer);
        ProductFactory productFactory = new ProductFactory(store);
        IProduct pizza1 = productFactory.getProduct(1, "Pizza",0, 1);




        IProduct pizza2 = productFactory.getProduct(2, "Pizza", 12.0, 1);
        IProduct cocacola = productFactory.getProduct(3, "coca-cola", 3.0, 2);
        shoppingCart.addToOrder(pizza1);
        shoppingCart.addToOrder(pizza2);
        shoppingCart.addToOrder(cocacola);
        shoppingCart.removeFromOrder(cocacola);
        shoppingCart.checkout();
    }
}
