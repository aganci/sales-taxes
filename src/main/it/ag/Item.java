package it.ag;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {
    public static Item parse(String input) {
        Pattern pattern = Pattern.compile("(\\d+)\\s(.+)\\sat\\s(\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(input);
        matcher.find();
        BigDecimal price = new BigDecimal(matcher.group(3));
        Integer quantity = new Integer(matcher.group(1));
        return new Item(quantity, matcher.group(2), price);
    }

    private final Integer quantity;
    private final String name;
    private final BigDecimal price;

    public Item(Integer quantity, String name, BigDecimal price) {

        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public BigDecimal priceWithTaxes() {
        return price.add(taxes());
    }

    public BigDecimal taxes() {
        BigDecimal taxes = BigDecimal.ZERO;
        if (taxIsApplicable()) {
            taxes = round(taxes.add(price.multiply(BigDecimal.valueOf(0.1))));
        }

        if (isImported()) {
            taxes = round(taxes.add(price.multiply(BigDecimal.valueOf(0.05))));
        }
        return taxes;
    }

    private boolean isImported() {
        return name.startsWith("imported");
    }

    private boolean taxIsApplicable() {
        if (name.equals("book"))
            return false;
        if (name.equals("chocolate bar"))
            return false;
        if (name.equals("imported box of chocolates"))
            return false;
        if (name.equals("packet of headache pills"))
            return false;
        return true;
    }

    private BigDecimal round(BigDecimal value) {
        return value.setScale(2, BigDecimal.ROUND_UP);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
