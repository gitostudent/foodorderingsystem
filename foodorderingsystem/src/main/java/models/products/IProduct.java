package models.products;

import models.orders.states.ShoppingCart.ShoppingCartVisitor;

public interface IProduct {
    public int getId();

    public double getPrice();

    public abstract double getTaxPercentage();

    public double accept(ShoppingCartVisitor visitor);
}
