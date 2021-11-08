package normal;

public class BuilderTest {

    public static void main(String[] args) {
        Person person = Person.Builder
                .builder("Song", "01012345678")
                .lastName("HeeJae")
                .age(26).build();

        System.out.println("person = " + person);
    }
}
