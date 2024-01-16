package part02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class OptionalValuesTest {
    private OptionalValues solution = new OptionalValues();

    @Test
    void testAverage() {
        IntStream numbers = IntStream.of(20, 0, 20, 0);

        assertEquals(10, solution.average(numbers));
    }

    @Test
    void testMaximum() {
        IntStream numbers = IntStream.of(20, 0, 20, 0);

        assertEquals(20, solution.maximum(numbers));
    }
}
