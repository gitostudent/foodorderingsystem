package models.products;

import models.products.Food.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class PriceComponent {
    private Map<Component,Double> component_price;

    public PriceComponent(){
        this.component_price = new HashMap<Component,Double>();
    }

    public PriceComponent(Map<Component, Double> price) {
        this.component_price = price;
    }
    public void setPrice(Component c, double new_price){
        component_price.put(c,new_price);
    }
    public double getPrice(Component c) throws Exception {
        if(!component_price.containsKey(c))
        {
            throw new Exception("Brak Ceny dla produktu");
        }
        return component_price.get(c);
    }
}
