package part05;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class FilteringStreamsTest {

    // the object to be tested
    private FilteringStreams solution = new FilteringStreams();

    @Test
    void testFilterEvenNumbers() {
        IntStream numbers = IntStream.of(1995, 2011, 2019, 2022);

        IntStream evenNumbers = solution.filterEvenNumbers(numbers);

        assertNotNull(evenNumbers);
        assertEquals(List.of(2022), evenNumbers.boxed().toList());
    }

    @Test
    void testFilterNumbersBetween() {
        IntStream numbers = IntStream.of(1995, 2011, 2019, 2022);

        IntStream numbersBetween = solution.filterNumbersBetween(numbers, 2000, 2020);

        assertNotNull(numbersBetween);
        assertEquals(List.of(2011, 2019), numbersBetween.boxed().toList());

    }

    @Test
    void testFilterStringsStartingWith() {
        Stream<String> words = Stream.of("@ohjelmointi2", "@python", "java@example.com", "stream", "lambda");

        Stream<String> wordsStartingWith = solution.filterStringsStartingWith(words, "@");

        assertNotNull(wordsStartingWith);
        assertEquals(List.of("@ohjelmointi2", "@python"), wordsStartingWith.toList());
    }

    @Test
    void testFilterIncludingSubstring() {
        Stream<String> words = List.of("ham", "hamster", "hammock", "java", "stream", "lambda").stream();

        Stream<String> included = solution.filterIncludingSubstring(words, "ham");

        assertNotNull(included);
        assertEquals(List.of("ham", "hamster", "hammock"), included.toList());
    }

    @Test
    void testFilterNotIncludingSubstring() {
        Stream<String> words = List.of("ham", "hamster", "hammock", "java", "stream", "lambda").stream();

        Stream<String> result = solution.filterNotIncludingSubstring(words, "ham");

        assertNotNull(result);
        assertEquals(List.of("java", "stream", "lambda"), result.toList());
    }

}
