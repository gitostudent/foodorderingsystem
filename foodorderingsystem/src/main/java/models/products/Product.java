package models.products;

import models.orders.states.ShoppingCart.ShoppingCartVisitor;

public interface Product {

    public double getPrice();

    public abstract double getTaxPercentage();

    public double accept(ShoppingCartVisitor visitor);
}
