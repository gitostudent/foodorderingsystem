package models.orders.payment.strategies;

import models.orders.payment.credentials.PaymentCredentials;

public class PaymentStrategyFactory {

    public PaymentStrategy getPaymentStrategy(String strategy, PaymentCredentials credentials) throws NoSuchPaymentStrategyException {
        if (strategy.toLowerCase().equals("paypal")) {
            return new PaypalStrategy(credentials);
        } else if (strategy.toLowerCase().equals("credit card")) {
            return new CreditCardStrategy(credentials);
        } else {
            throw new NoSuchPaymentStrategyException();
        }
    }
}
