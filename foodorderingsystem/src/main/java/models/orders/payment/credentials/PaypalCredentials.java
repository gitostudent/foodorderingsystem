package models.orders.payment.credentials;

import java.util.Scanner;

public class PaypalCredentials implements PaymentCredentials {

    Scanner scanner = new Scanner(System.in);

    private String login;
    private String password;

    public void setPaymentCredentials(String[] credentials) {
        login = credentials[0];
        password = credentials[1];
    }

    public void setPaymentCredentials() {
        String[] credentials = new String[2];
        System.out.print("login: ");
        credentials[0] = scanner.nextLine();
        System.out.println("password: ");
        credentials[1] = scanner.nextLine();

        setPaymentCredentials(credentials);
    }
}
