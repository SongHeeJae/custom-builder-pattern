package custom;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    private Person(Builder builder) {
        this.firstName = builder.step.firstName;
        this.lastName = builder.step.lastName;
        this.age = builder.step.age;
        this.phoneNumber = builder.step.phoneNumber;
    }

    public interface FirstNameStep {
        LastNameStep firstName(String firstName);
    }

    public interface LastNameStep {
        AgeStep lastName(String lastName);
    }

    public interface AgeStep {
        PhoneNumberStep age(int age);
    }

    public interface PhoneNumberStep {
        Builder phoneNumber(String phoneNumber);
    }

    public static class Step implements FirstNameStep, LastNameStep, AgeStep, PhoneNumberStep {
        private String firstName;
        private String lastName;
        private int age;
        private String phoneNumber;
        private Builder builder;

        public Step(Builder builder) {
            this.builder = builder;
        }

        @Override
        public LastNameStep firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public AgeStep lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public PhoneNumberStep age(int age) {
            this.age = age;
            return this;
        }

        @Override
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return builder;
        }
    }

    public static class Builder {
        private Step step = new Step(this);
        public static FirstNameStep builder() {
            return new Builder().step;
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
