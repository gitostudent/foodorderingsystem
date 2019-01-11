package models.orders.payment.credentials;

import models.customers.Name;

import java.util.Scanner;

public class CreditCardCredentials implements PaymentCredentials {

    Scanner scanner = new Scanner(System.in);

    private Name name;
    private String cardNumber;
    private String ccv;
    private String dateOfExpiry;

    public void setPaymentCredentials(String[] credentials) {
        name = new Name.NameBuilder(credentials[0], credentials[1]).build();
        cardNumber = credentials[2];
        ccv = credentials[3];
        dateOfExpiry = credentials[4];
    }

    public void setPaymentCredentials() {
        String[] credentials = new String[4];
        System.out.println("forename: ");
        credentials[0] = scanner.nextLine();
        System.out.println("surname: ");
        credentials[1] = scanner.nextLine();
        System.out.println("ccv: ");
        credentials[2] = scanner.nextLine();
        System.out.println("date of expiry: ");
        credentials[3] = scanner.nextLine();

        setPaymentCredentials(credentials);
    }
}
