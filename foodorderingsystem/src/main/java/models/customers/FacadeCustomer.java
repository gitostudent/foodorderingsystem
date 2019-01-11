package models.customers;

public class FacadeCustomer {

    int customerId;
    static FacadeCustomer INSTANCE = new FacadeCustomer();

    public static FacadeCustomer getInstance() {
        return INSTANCE;
    }

    private FacadeCustomer() {
        customerId = 0;
    }

    public Customer getCustomer(String firstName, String lastName) {
        ++customerId;
        return new Customer(customerId, new Name.NameBuilder(firstName, lastName).build());
    }

    public Customer getCustomer(String firstName, String secondName, String lastName) {
        ++customerId;
        return new Customer(customerId, new Name.NameBuilder(firstName, lastName).withSecondName(secondName).build());
    }
}
