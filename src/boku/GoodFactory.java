/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boku;

import boku.model.Medical;
import boku.model.Book;
import boku.model.Food;
import boku.model.Good;
import java.math.BigDecimal;

/**
 *
 * @author wongp3
 */
public class GoodFactory {

    private static final String BOOK = "book";
    private static final String CHOCOLATE = "chocolate";
    private static final String HEADACHE_PILLS = "headache pills";
    private static final String IMPORTED = "imported";
    private static final String AT = " at ";
    private static final String PRICE_ERROR = "Error reading the good's price";
    private static final String QUANTITY_ERROR = "Error reading the good's quantity";

    public static Good getGood(String goodStr) {
        boolean isImported = false;
        BigDecimal price = null;
        int quantity = 0;
        String description = "";

        isImported = goodStr.contains(IMPORTED);

        // split the string at the AT string to get the quantity/description and price strings
        String quantityAndDescription = null;
        String[] splitResult = goodStr.split(AT);
        if (splitResult.length > 2) {
            System.err.println("bad input");
        } else {
            quantityAndDescription = splitResult[0];
            try {
                price = new BigDecimal(splitResult[1]);
            } catch (NumberFormatException ex) {
                System.err.println(PRICE_ERROR);
            }
        }

        // split the quantityAndDescription string to parse the quantity
        splitResult = quantityAndDescription.split(" ");
        try {
            // the quantity should always be the first string in the splitResult
            quantity = Integer.parseInt(splitResult[0]);
        } catch (NumberFormatException ex) {
            System.err.println(QUANTITY_ERROR);
        }

        // rebuild the description string because it was split earlier
        StringBuilder sbDescription = new StringBuilder();
        for (int i = 1; i < splitResult.length; i++) {
            sbDescription.append(splitResult[i]);
            sbDescription.append(" ");
        }
        // remove the trailing white space
        description = sbDescription.substring(0, sbDescription.length() - 1);

        GoodType goodType = determineGoodType(goodStr);

        switch (goodType) {
            case BOOK:
                return new Book(quantity, description, price, isImported);
            case FOOD:
                return new Food(quantity, description, price, isImported);
            case MEDICAL:
                return new Medical(quantity, description, price, isImported);
            default:
                return new Good(quantity, description, price, isImported);
        }
    }

    private static GoodType determineGoodType(String goodStr) {
        if (goodStr.contains(BOOK)) {
            return GoodType.BOOK;
        } else if (goodStr.contains(CHOCOLATE)) {
            return GoodType.FOOD;
        } else if (goodStr.contains(HEADACHE_PILLS)) {
            return GoodType.MEDICAL;
        } else {
            return GoodType.OTHER;
        }
    }
}
