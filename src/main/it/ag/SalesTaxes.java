package it.ag;

import com.sun.deploy.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesTaxes {
    public String printReceiptFor(String input) {
        String[] lines = input.split("\n");

        BigDecimal total = BigDecimal.ZERO;
        BigDecimal taxes = BigDecimal.ZERO;

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            Item item = Item.parse(lines[i]);
            output.append(item.getQuantity() + " " + item.getName() + ": " + formatNumber(item.priceWithTaxes()) + "\n");
            total = total.add(item.priceWithTaxes());
            taxes = taxes.add(item.taxes());
        }

        output.append("Sales Taxes: " + formatNumber(taxes)  + "\n");
        output.append("Total: " + formatNumber(total));

        return output.toString();
    }

    private String formatNumber(BigDecimal value) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        df.setGroupingUsed(false);
        return df.format(value);
    }
}
