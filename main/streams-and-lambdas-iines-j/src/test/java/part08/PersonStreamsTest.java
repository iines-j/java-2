package part08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import person.Person;

public class PersonStreamsTest {

    // the objects to be used in the tests
    private List<Person> persons = List.of(
            new Person("Ada", 10),
            new Person("Bob", 20),
            new Person("Carol", 30));

    // the object to be tested
    private PersonStreams solution = new PersonStreams();

    @Test
    void testGetAdults() {
        Stream<Person> adults = solution.getAdults(persons.stream());

        assertNotNull(adults);
        assertEquals(persons.subList(1, 3), adults.toList());
    }

    @Test
    void testIncrementAge() {
        Stream<Person> incremented = solution.incrementAge(persons.stream());

        assertNotNull(incremented);
        assertEquals(List.of(
                new Person("Ada", 11),
                new Person("Bob", 21),
                new Person("Carol", 31)), incremented.toList());
    }

    @Test
    void testCsvToPersons() {
        Stream<String> csvLines = Stream.of(
                "Ada,10",
                "Bob,20",
                "Carol,30");

        Stream<Person> generated = solution.csvToPersons(csvLines);

        assertNotNull(generated);
        assertEquals(persons, generated.toList());
    }

}
