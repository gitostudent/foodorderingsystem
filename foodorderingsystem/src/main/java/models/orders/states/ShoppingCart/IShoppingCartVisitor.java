package models.orders.states.ShoppingCart;

import models.products.IProduct;

public interface IShoppingCartVisitor {

    double visit(IProduct food);
}
