package models.orders.payment.strategies;

import models.orders.payment.credentials.PaymentCredentials;

public class PaypalStrategy implements PaymentStrategy {

    PaymentCredentials paypalCredentials;

    public PaypalStrategy(PaymentCredentials paypalCredentials) {
        this.paypalCredentials = paypalCredentials;
    }


    public void pay(double amount) {
        System.out.println(amount + " paid using PayPal");
    }
}
