package exercises.section07;

import exercises.section07.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    String input;
    List<Person> expectedPeople;

    @BeforeEach
    void SetUp() {
        expectedPeople = new ArrayList<Person>();
    }
    @Test
    public void CreatesAPersonFromASingleString() {
        input = "Billy, Bob, 1234 Big St., Big City, California, 90210";
        expectedPeople.add(new Person("Billy", "Bob", "1234", "Big St.", "Big City", "California", "90210"));
        List<Person> people = Person.parse(input);
        assertEquals(expectedPeople, people);
    }

    @Test
    public void ReturnsEmptyArrayForEmptyInput() {
        input = "";
        List<Person> people = Person.parse(input);
        assertEquals(expectedPeople, people);
    }

    @Test
    public void ReturnedListSizeCorrespondsInputSize() {
        input = "Billy, Bob, 1234 Big St., Big City, California, 90210 | Joe, Smith, 5678 Little St., Little City, New York, 20109";
        List<Person> people = Person.parse(input);
        assertEquals(2, people.size());
    }
}
