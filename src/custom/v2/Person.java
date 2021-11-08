package custom.v2;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phoneNumber = builder.phoneNumber;
    }

    public interface FirstName {
        LastName firstName(String firstName);
    }

    public interface LastName {
        OptionalBuilder lastName(String lastName);
    }

    public interface OptionalBuilder {
        OptionalBuilder age(int age);
        OptionalBuilder phoneNumber(String phoneNumber);
        Person build();
    }


    public static class Builder implements FirstName, LastName, OptionalBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String phoneNumber;

        private Builder() {}

        public static FirstName builder() {
            return new Builder();
        }

        @Override
        public LastName firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public OptionalBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public OptionalBuilder age(int age) {
            this.age = age;
            return this;
        }

        @Override
        public OptionalBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
