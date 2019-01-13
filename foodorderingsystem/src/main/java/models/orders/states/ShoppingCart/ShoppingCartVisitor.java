package models.orders.states.ShoppingCart;

import models.products.IProduct;

public class ShoppingCartVisitor implements IShoppingCartVisitor {

    public double visit(IProduct product) {
        return product.getPrice();
    }
}
