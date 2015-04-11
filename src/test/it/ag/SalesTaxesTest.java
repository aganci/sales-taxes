package it.ag;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalesTaxesTest {
    @Test
    public void booksAreExempt() {
        String result = new SalesTaxes().printReceiptFor("1 book at 12.49");

        assertEquals(
                "1 book: 12.49\n" +
                "Sales Taxes: 0.00\n" +
                "Total: 12.49", result);
    }
}