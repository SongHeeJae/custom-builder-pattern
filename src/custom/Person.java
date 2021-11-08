package custom;

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

    public interface FirstNameBuilder {
        LastNameBuilder firstName(String firstName);
    }

    public interface LastNameBuilder {
        AgeBuilder lastName(String lastName);
    }

    public interface AgeBuilder {
        PhoneNumberBuilder age(int age);
    }

    public interface PhoneNumberBuilder {
        BuildBuilder phoneNumber(String phoneNumber);
    }

    public interface BuildBuilder {
        Person build();
    }

    public static class Builder implements FirstNameBuilder, LastNameBuilder, AgeBuilder, PhoneNumberBuilder, BuildBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String phoneNumber;

        private Builder() {}

        public static FirstNameBuilder builder() {
            return new Builder();
        }

        @Override
        public LastNameBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public AgeBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public PhoneNumberBuilder age(int age) {
            this.age = age;
            return this;
        }

        @Override
        public BuildBuilder phoneNumber(String phoneNumber) {
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
