package models.products.Food;

import models.products.IStoreHandler;

public class FoodFactory {
    protected IStoreHandler store;
    public FoodFactory(IStoreHandler store){
        this.store=store;
    }
    public Food getFood(int id, String name, double price) throws Exception {
        if (name == "Pizza") {
            PizzaDirector director=new PizzaDirector(store);
            director.construct(id);
            return director.getPizza();
        }
        else {
            return new Food(id, name, price);
        }
    }
}
