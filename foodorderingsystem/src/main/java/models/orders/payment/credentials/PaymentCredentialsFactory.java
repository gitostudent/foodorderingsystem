package models.orders.payment.credentials;

public class PaymentCredentialsFactory {

    public PaymentCredentials getPaymentCredentials(String strategy) throws NoSuchStrategyException {
        if (strategy.toLowerCase().equals("paypal")) {
            return new PaypalCredentials();
        } else if (strategy.toLowerCase().equals("credit card")) {
            return new CreditCardCredentials();
        } else {
            System.out.println("No such strategy");
            throw new NoSuchStrategyException();
        }
    }
}
