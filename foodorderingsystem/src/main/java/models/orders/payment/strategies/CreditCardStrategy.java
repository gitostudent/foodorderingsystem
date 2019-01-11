package models.orders.payment.strategies;

import models.orders.payment.credentials.PaymentCredentials;

public class CreditCardStrategy implements PaymentStrategy {

    PaymentCredentials creditCardCredentials;

    public CreditCardStrategy(PaymentCredentials creditCardCredentials) {
        this.creditCardCredentials = creditCardCredentials;
    }


    public void pay(double amount) {
        System.out.println(amount + " paid by credit card");
    }
}
