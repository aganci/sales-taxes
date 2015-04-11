package it.ag;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SalesTaxesInputTest {
    @Test
    public void input() {
        String result = new SalesTaxes().printReceiptFor(
                "1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85");

        assertEquals(
                "1 book : 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50",
                result);
    }
}