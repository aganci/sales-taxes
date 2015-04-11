package it.ag;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void ImportDuty() {
        Item item = new Item(1, "imported box of chocolates", BigDecimal.valueOf(10));

        assertEquals(0, BigDecimal.valueOf(0.5).compareTo(item.taxes()));
    }

    @Test
    public void ImportDutyAndStandartTaxes() {
        Item item = new Item(1, "imported box of perfume", BigDecimal.valueOf(47.50));

        assertEquals(0, BigDecimal.valueOf(7.15).compareTo(item.taxes()));
    }
}