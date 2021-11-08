package normal;

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

    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String phoneNumber;

        public static Builder builder(String firstName, String phoneNumber) {
            Builder builder = new Builder();
            builder.firstName = firstName;
            builder.phoneNumber = phoneNumber;
            return builder;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

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