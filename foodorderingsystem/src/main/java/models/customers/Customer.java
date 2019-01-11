package models.customers;

public class Customer {

    private int id;
    private Name name;

    public Customer(int id, Name name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }
}
