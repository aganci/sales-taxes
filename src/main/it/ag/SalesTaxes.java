package it.ag;

import com.sun.deploy.util.StringUtils;

public class SalesTaxes {
    public String printReceiptFor(String input) {
        String[] tokens = StringUtils.splitString(input, " ");
        return
                tokens[0] + " " + tokens[1] + ": " + tokens[3] + "\n" +
                "Sales Taxes: 0.00\n" +
                "Total: " + tokens[3];
    }
}
