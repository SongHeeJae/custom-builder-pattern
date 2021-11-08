package custom.v2;

public class BuilderTest {
    public static void main(String[] args) {
        Person person = Person.Builder
                .builder()
                .firstName("Song")
                .lastName("HeeJae")
                .age(26)
                .phoneNumber("01012345678").build();

        System.out.println("person = " + person);
    }
}

