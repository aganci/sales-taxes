package it.ag;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void shouldApplyTaxes() {
        String result = new SalesTaxes().printReceiptFor("1 music CD at 14.99");

        assertEquals(
                "1 music CD: 16.49\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 16.49", result);
    }
}