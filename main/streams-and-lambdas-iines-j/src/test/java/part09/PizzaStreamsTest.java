package part09;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import pizza.Pizza;

public class PizzaStreamsTest {

    // the data that we need for the tests
    private final Pizza margherita = new Pizza("Margherita", 8.99,
            List.of("tomato sauce", "mozzarella", "basil"));
    private final Pizza pepperoni = new Pizza("Pepperoni", 10.99,
            List.of("tomato sauce", "pepperoni", "mozzarella"));
    private final Pizza vegetarian = new Pizza("Vegetarian", 9.99,
            List.of("tomato sauce", "mushrooms", "bell peppers", "onions", "mozzarella"));

    private final Pizza hawaiian = new Pizza("Hawaiian", 11.99,
            List.of("tomato sauce", "ham", "pineapple", "mozzarella"));
    private final Pizza tropical = new Pizza("Tropical", 13.99,
            List.of("tomato sauce", "chicken", "pineapple", "banana peppers", "mozzarella"));
    private final Pizza bbq = new Pizza("BBQ Chicken", 12.99,
            List.of("bbq sauce", "chicken", "pineapple", "red onions", "mozzarella"));

    private final List<Pizza> pizzas = List.of(margherita, pepperoni, vegetarian, hawaiian, tropical, bbq);

    // the object that we want to test
    private PizzaStreams solution = new PizzaStreams();

    @Test
    void testGetPizzasWithPineapple() {
        Stream<Pizza> withPineapple = solution.getPizzasWithPineapple(pizzas.stream());

        assertNotNull(withPineapple);
        assertEquals(List.of(hawaiian, tropical, bbq), withPineapple.toList());
    }

    @Test
    void testGetPizzasWithoutPineapple() {
        Stream<Pizza> withoutPineapple = solution.getPizzasWithoutPineapple(pizzas.stream());

        assertNotNull(withoutPineapple);
        assertEquals(List.of(margherita, pepperoni, vegetarian), withoutPineapple.toList());
    }

    @Test
    void testGetPizzasWithTopping() {
        Stream<Pizza> withBasil = solution.getPizzasWithTopping(pizzas.stream(), "basil");

        assertNotNull(withBasil);
        assertEquals(List.of(margherita), withBasil.toList());

    }

    @Test
    void testGetPizzasWithAnyOfToppings() {
        Stream<Pizza> withBasilOrChicken = solution.getPizzasWithAnyOfToppings(pizzas.stream(),
                List.of("basil", "chicken"));

        assertNotNull(withBasilOrChicken);
        assertEquals(List.of(margherita, tropical, bbq), withBasilOrChicken.toList());
    }

    @Test
    void testSortPizzasByPrice() {
        Stream<Pizza> sortedByPrice = solution.sortPizzasByPrice(pizzas.stream());

        assertNotNull(sortedByPrice);
        assertEquals(List.of(margherita, vegetarian, pepperoni, hawaiian, bbq, tropical), sortedByPrice.toList());
    }

    @Test
    void testSortPizzasByName() {
        Stream<Pizza> sortedByName = solution.sortPizzasByName(pizzas.stream());

        assertNotNull(sortedByName);
        assertEquals(List.of(bbq, hawaiian, margherita, pepperoni, tropical, vegetarian), sortedByName.toList());
    }
}
