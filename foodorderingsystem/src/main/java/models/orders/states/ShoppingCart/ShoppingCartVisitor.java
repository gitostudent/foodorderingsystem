package models.orders.states.ShoppingCart;

import models.products.Product;

public class ShoppingCartVisitor implements IShoppingCartVisitor {

    public double visit(Product product) {
        return product.getPrice();
    }
}
