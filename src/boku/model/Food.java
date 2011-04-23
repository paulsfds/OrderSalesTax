/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boku.model;

import java.math.BigDecimal;

/**
 *
 * @author wongp3
 */
public class Food extends Good {

    public Food(int quantity, String description, BigDecimal price, boolean isImported) {
        super(quantity, description, price, isImported);
    }

    @Override
    public boolean isExempt() {
        return true;
    }
}
