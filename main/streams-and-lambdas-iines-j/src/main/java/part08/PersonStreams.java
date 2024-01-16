package part08;

import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;

import person.Person;

/**
 * This class applies the concepts of previous exercises with Person objects.
 * Person objects can be filtered, mapped and collected just like any other
 * objects.
 */
public class PersonStreams {

    /**
     * Returns a stream of adults in the specified stream of persons.
     * An adult is a person whose age is 18 or over.
     *
     * @param persons the stream to filter
     * @return a stream of the adults in the given stream
     */
    public Stream<Person> getAdults(Stream<Person> persons) {
        // Hint: you can call the `age()` method on a Person object to get the age.
        Stream<Person> n = persons.filter(x -> x.age() >= 18);
        return n;
    }

    /**
     * Returns a stream of new Person objects with ages incremented by one.
     *
     * @param persons the stream of objects
     * @return a stream of new Person objects with incremented ages
     */
    public Stream<Person> incrementAge(Stream<Person> persons) {
        /*
         * Hint: you cannot modify the age of the persons in the original stream. You
         * need to create new Person objects.
         *
         * Use the `map()` method to create new stream and the `Person` constructor to
         * create new Person objects with incremented ages. The name and age of a Person
         * object can be accessed using the `name()` and `age()` methods.
         */
        Stream<Person> n = persons.map(x -> new Person(x.name(), x.age() + 1));
        return n;
    }

    /**
     * Returns a stream of People objects that have been created based on the lines
     * in the specified stream of Strings. Each string contains the name and age of
     * a person separated by a comma.
     *
     * For example, the line "Ada,20" creates a person object with the name "Ada"
     * and the age 20.
     *
     * @param csvLines the stream of lines from a CSV file
     * @return a stream of Person objects
     */
    public Stream<Person> csvToPersons(Stream<String> csvLines) {
        // tf do you mean
        List<String> n = csvLines.toList();
        Person[] pArr = new Person[n.size()];

        for (int i = 0; i < n.size(); i++) {
            String[] arr = n.get(i).split(",", 2);
            pArr[i] = new Person(arr[0], Integer.parseInt(arr[1]));
        }

        Stream<Person> z = Arrays.stream(pArr);
        return z;
    }
}
