package models.orders.states.ShoppingCart;

import models.products.Product;

public interface IShoppingCartVisitor {

    double visit(Product food);
}
