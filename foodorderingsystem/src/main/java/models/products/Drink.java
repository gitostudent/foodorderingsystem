package models.products;

import models.orders.states.ShoppingCart.ShoppingCartVisitor;

public class Drink implements Product {

    private int id;
    private String name;
    private double price;

    public Drink(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

    public double getPrice() {
        return this.price;
    }

    public double getTaxPercentage() {
        return 0.23;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
