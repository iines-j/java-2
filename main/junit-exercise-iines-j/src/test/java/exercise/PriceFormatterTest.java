package exercise;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import price.formatter.PriceFormatter;

/**
 * Write your tests for the PriceFormatter here. See the specification of the
 * PriceFormatter and formatPrice method in the PriceFormatter class.
 */
public class PriceFormatterTest {

    @Test
    void testFormatter() {
        PriceFormatter formatter = new PriceFormatter();

        assertEquals("123 456,78 €", formatter.formatPrice(123456.78));
        assertEquals("1,30 €", formatter.formatPrice(1.30));
        assertEquals("200 000,01 €", formatter.formatPrice(200000.009));
        assertEquals("1 111,11 €", formatter.formatPrice(1111.11111111111));
    }

    @Test
    void testRounding() {
        PriceFormatter formatter = new PriceFormatter();

        assertEquals("1,98 €", formatter.formatPrice(1.977));
        assertEquals("1 000,99 €", formatter.formatPrice(1000.987));
        assertEquals("200 002 €", formatter.formatPrice(200001.999));
        assertEquals("1,99 €", formatter.formatPrice(1.99));
    }

    @Test
    void testZero() {
        PriceFormatter formatter = new PriceFormatter();

        assertEquals("1 234 €", formatter.formatPrice(1234.00));
        assertEquals("2 €", formatter.formatPrice(1.999));
        assertEquals("1 €", formatter.formatPrice(1.00001));
    }

    /*
     * The formatPrice method takes a double as a parameter and returns a String:
     *
     * PriceFormatter formatter = new PriceFormatter();
     * String formatted = formatter.formatPrice(Math.PI); // 3.14 €
     *
     * Call the method with different values in your tests and check that the
     * returned Strings match the specification.
     */
}
