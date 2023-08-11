package exercises.section07;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String firstName;
    private String lastName;
    private String streetNumber;
    private String street;
    private String city;
    private String state;
    private String code;

    public Person(String firstName, String lastName, String streetNumber, String street, String city, String state, String code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(streetNumber, person.streetNumber) && Objects.equals(street, person.street) && Objects.equals(city, person.city) && Objects.equals(state, person.state) && Objects.equals(code, person.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, streetNumber, street, city, state, code);
    }

    public static List<Person> parse(String input) {
        String separator = "\\|";
        String regexp = """
            (?<firstName>[\\w\\s]+),\\s
            (?<lastName>[\\w\\s]+),\\s
            (?<streetNumber>[\\d]+)\\s
            (?<street>[\\w\\s\\.]+),\\s
            (?<city>[\\w\\s\\.]+),\\s
            (?<state>[\\w\\s]+),\\s
            (?<code>[\\d]{5})
        """;
        List<Person> people = new ArrayList<Person>();
        Pattern pattern = Pattern.compile(regexp, Pattern.DOTALL | Pattern.COMMENTS);
        Matcher matcher;

        for(String inp: input.split(separator)) {
            matcher = pattern.matcher(inp.strip());

            if (matcher.matches()) {
                people.add(new Person(
                        matcher.group("firstName"),
                        matcher.group("lastName"),
                        matcher.group("streetNumber"),
                        matcher.group("street"),
                        matcher.group("city"),
                        matcher.group("state"),
                        matcher.group("code")
                ));
            }
        }

        return people;
    }
}
