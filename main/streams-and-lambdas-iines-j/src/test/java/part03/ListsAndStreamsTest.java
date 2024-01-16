package part03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class ListsAndStreamsTest {

    // the object to be tested
    private ListsAndStreams solution = new ListsAndStreams();

    @Test
    void testMakeStream() {
        Stream<String> generated = solution.makeStream(List.of("Monica", "Chandler", "Phoebe"));

        // check that the names are correct
        assertNotNull(generated);
        assertEquals(List.of("Monica", "Chandler", "Phoebe"), generated.toList());
    }

    @Test
    void testMakeList() {
        List<String> names = List.of("Monica", "Chandler", "Phoebe");
        List<String> generated = solution.makeList(names.stream());

        assertNotNull(generated);
        assertEquals(names, generated);
    }

    @Test
    void testStreamWithLimit() {
        List<String> names = List.of("Monica", "Chandler", "Phoebe", "Ross", "Rachel", "Joey");

        Stream<String> generated = solution.streamWithLimit(names, 2);

        assertNotNull(generated);
        assertEquals(List.of("Monica", "Chandler"), generated.toList());
    }
}
