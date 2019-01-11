package models.products;

public class ProductFactory {

    //categories: 1-food, 2-drink
    public Product getProduct(int id, String name, double price, int category) {
        if (category == 1) {
            return new Food(id, name, price);
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
