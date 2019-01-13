package models.products;

import models.products.Food.Food;
import models.products.Food.FoodFactory;

public class ProductFactory {
    protected IStoreHandler store;
    public ProductFactory(IStoreHandler store){
        this.store=store;
    }
    //categories: 1-food, 2-drink
    public IProduct getProduct(int id, String name, double price, int category) {
        if (category == 1) {
            try {
                return (new FoodFactory(store)).getFood(id, name, price);
            } catch (Exception e) {
                System.out.println("Cant Create Product");
                e.printStackTrace();
                return null;
            }
        }
        else if (category == 2) {
            return new Food(id, name, price);
        }
        else {
            System.out.println("No such Product category: " + category);
            return null;
        }
    }
}
