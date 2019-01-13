package models.products;

import models.products.Food.Component;

import java.util.List;

public interface IStoreHandler {
    List<Component> getDoughts();
    List<Component> getChesee();
    List<Component> getToppings();
    List<Component> getVegeDoughts();
    List<Component> getVegeChesee();
    List<Component> getVegeToppings();
    void addComponent(Component e);
    void removeComponent(Component e);
    double getComponentPrice(Component e);

}
