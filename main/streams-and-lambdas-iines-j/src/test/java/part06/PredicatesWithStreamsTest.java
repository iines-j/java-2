package part06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class PredicatesWithStreamsTest {

    // the object to be tested
    private PredicatesWithStreams solution = new PredicatesWithStreams();

    @Test
    void testAllPositive() {
        IntStream positives = IntStream.of(1, 2, 3, 4, 5);
        IntStream negatives = IntStream.of(-1, -2, -3, -4, -5);
        IntStream mixed = IntStream.of(-1, 2, -3, 4, -5);

        assertTrue(solution.allPositive(positives));

        assertFalse(solution.allPositive(negatives));
        assertFalse(solution.allPositive(mixed));
    }

    @Test
    void testGetFirstPositive() {
        IntStream mixed = IntStream.of(-1, -2, -3, 4, 5);
        IntStream negatives = IntStream.of(-1, -2, -3, -4, -5);

        int firstPositive = solution.getFirstPositive(mixed);
        assertEquals(4, firstPositive);

        assertEquals(0, solution.getFirstPositive(negatives));
    }

    @Test
    void testContainsNoNulls() {
        Stream<String> noNulls = Stream.of("a", "b", "c");
        Stream<String> withNulls = Stream.of("a", null, "b", null, "c");

        assertTrue(solution.containsNoNulls(noNulls));
        assertFalse(solution.containsNoNulls(withNulls));
    }

}
