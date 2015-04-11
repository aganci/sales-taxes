package it.ag;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SalesTaxesInputTest {
    @Test
    public void input1() {
        String result = new SalesTaxes().printReceiptFor(
                "1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85");

        assertEquals(
                "1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83",
                result);
    }

    @Test
    public void input2() {
        String result = new SalesTaxes().printReceiptFor(
                "1 imported box of chocolates at 10.00\n" +
                "1 imported bottle of perfume at 47.50");

        assertEquals(
                "1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.63\n" +
                "Sales Taxes: 7.63\n" +
                "Total: 65.13",
                result);
    }

    @Test
    public void input3() {
        String result = new SalesTaxes().printReceiptFor(
                "1 imported bottle of perfume at 27.99\n" +
                "1 bottle of perfume at 18.99\n" +
                "1 packet of headache pills at 9.75\n" +
                "1 imported box of chocolates at 11.25\n"
        );

        assertEquals(
                "1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 imported box of chocolates: 11.82\n" +
                "Sales Taxes: 6.67\n" +
                "Total: 74.65"
                , result);
    }
}