package models.products.Food.Pizza;

import models.products.Food.Component;

import java.util.List;

public interface IPizzaBuilder {
    void buildDough() throws Exception;
    void buildChesee() throws Exception;
    void buildToppings();
    void buildPrice();
    Pizza getPizza();
};

