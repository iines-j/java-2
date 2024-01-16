package part01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class IntegerStreamsTest {

    // the object to be tested
    private IntegerStreams solution = new IntegerStreams();

    @Test
    void testNumbersBetween() {
        IntStream numbersBetween = solution.numbersBetween(10, 100);
        List<Integer> numbers = numbersBetween.boxed().toList();

        // check that the numbers are correct
        assertEquals(91, numbers.size());
        assertEquals(10, numbers.get(0));
        assertEquals(100, numbers.get(90));
    }

    @Test
    void testSum() {
        IntStream numbers = IntStream.of(10, 20, 12);

        assertEquals(42, solution.sum(numbers));
    }

    @Test
    void testCountNumbersInStream() {
        IntStream numbers = IntStream.of(10, 20, 12);

        assertEquals(3, solution.countNumbersInStream(numbers));

        assertEquals(0, solution.countNumbersInStream(IntStream.empty()));
    }

}
