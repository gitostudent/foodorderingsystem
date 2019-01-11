package models.products;

import models.orders.states.ShoppingCart.ShoppingCartVisitor;

public class Food implements Product {

    private int id;
    private String name;
    private double price;

    public Food(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public double getTaxPercentage() {
        return 0.08;
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
