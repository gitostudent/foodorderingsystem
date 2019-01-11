package models.customers;

public class Name {

    public static class NameBuilder {

        private String firstName;
        private String secondName;
        private String lastName;

        public NameBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public NameBuilder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }

    private String firstName;
    private String secondName;
    private String lastName;

    private Name(NameBuilder builder) {
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.lastName = builder.lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
