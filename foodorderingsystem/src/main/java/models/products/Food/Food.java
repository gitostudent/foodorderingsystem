package models.products.Food;

import models.orders.states.ShoppingCart.ShoppingCartVisitor;
import models.products.IProduct;

public class Food implements IProduct {

    private int id;
    private String name;
    private double price;

    public Food(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    public double getPrice() {
        return this.price;
    }

    public double getTaxPercentage() {
        return 0.08;
    }

    public void setPrice(double value) {
        this.price=value;
    }


    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
