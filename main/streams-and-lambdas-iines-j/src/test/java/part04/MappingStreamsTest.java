package part04;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class MappingStreamsTest {

    // the object to be tested
    private MappingStreams solution = new MappingStreams();

    @Test
    void testDoubleValuesInStream() {
        IntStream numbers = IntStream.of(1995, 2011, 2019, 2022);

        IntStream doubled = solution.doubleValuesInStream(numbers);

        assertNotNull(doubled);
        assertEquals(List.of(2 * 1995, 2 * 2011, 2 * 2019, 2 * 2022), doubled.boxed().toList());
    }

    @Test
    void testMultiplyValuesInStream() {
        IntStream numbers = IntStream.of(1995, 2011, 2019, 2022);

        IntStream tripled = solution.multiplyValuesInStream(numbers, 3);

        assertNotNull(tripled);
        assertEquals(List.of(3 * 1995, 3 * 2011, 3 * 2019, 3 * 2022), tripled.boxed().toList());
    }

    @Test
    void testMapListToIntStream() {
        List<Integer> numbers = List.of(1995, 2011, 2019, 2022);

        IntStream stream = solution.mapListToIntStream(numbers);

        assertNotNull(stream);

        // must have the same values as the original list
        assertEquals(numbers, stream.boxed().toList());
    }

    @Test
    void testPrefixAllStrings() {
        Stream<String> urls = Stream.of("ohjelmointi2.github.io", "python-ohjelmointi.github.io");
        Stream<String> prefixed = solution.prefixAllStrings(urls, "https://");

        assertNotNull(prefixed);
        assertEquals(List.of("https://ohjelmointi2.github.io", "https://python-ohjelmointi.github.io"),
                prefixed.toList());
    }

    @Test
    void testSuffixAllStrings() {
        Stream<String> files = Stream.of("noreply", "abuse", "admin");
        Stream<String> withExtension = solution.suffixAllStrings(files, "@example.com");

        assertNotNull(withExtension);
        assertEquals(List.of("noreply@example.com", "abuse@example.com", "admin@example.com"), withExtension.toList());
    }

    @Test
    void testRemoveSuffix() {
        Stream<String> files = Stream.of("cv.pdf", "thesis.pdf", "photo.png", "letter.pdf");
        Stream<String> removed = solution.removeSuffix(files, ".pdf");

        assertNotNull(removed);
        assertEquals(List.of("cv", "thesis", "photo.png", "letter"), removed.toList());
    }

    @Test
    void testStreamFizzBuzz() {
        IntStream numbers = IntStream.rangeClosed(1, 5);

        Stream<String> fizzBuzz = solution.streamFizzBuzz(numbers);

        assertNotNull(fizzBuzz);
        assertEquals(List.of("1", "2", "fizz", "4", "buzz"), fizzBuzz.map(String::toLowerCase).toList());

        // test that the logic handles multiples of both 3 and 5 correctly
        IntStream fifteen = IntStream.rangeClosed(15, 15);
        assertEquals(List.of("fizzbuzz"), solution.streamFizzBuzz(fifteen).map(String::toLowerCase).toList());
    }
}
