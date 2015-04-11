package it.ag;

import com.sun.deploy.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesTaxes {
    public String printReceiptFor(String input) {
        Item item = Item.parse(input);

        return
                item.getQuantity() + " " + item.getName() + ": " + formatNumber(item.priceWithTaxes()) + "\n" +
                "Sales Taxes: " + formatNumber(item.taxes())  + "\n" +
                "Total: " + formatNumber(item.priceWithTaxes());
    }

    private String formatNumber(BigDecimal value) {
        BigDecimal bd = value.setScale(2, BigDecimal.ROUND_UP);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        df.setGroupingUsed(false);
        return df.format(bd);
    }
}
