/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boku;

import boku.model.Good;
import java.math.BigDecimal;

/**
 *
 * @author wongp3
 */
public class Tax {

    private static final BigDecimal SALES_TAX = new BigDecimal("0.10");
    private static final BigDecimal IMPORT_DUTY = new BigDecimal("0.05");
    private static final BigDecimal ROUNDING_PRECISION = new BigDecimal("0.05");
    private BigDecimal salesTax;
    private BigDecimal importTax;
    private BigDecimal totalTax;
    private Good good;

    public Tax(Good good) {
        salesTax = new BigDecimal("0.0");
        importTax = new BigDecimal("0.0");
        totalTax = new BigDecimal("0.0");
        this.good = good;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void calculate(BigDecimal price, boolean isExempt, boolean isImported) {
        if (!isExempt) {
            salesTax = SALES_TAX.multiply(price);
        }

        if (isImported) {
            importTax = IMPORT_DUTY.multiply(price);
        }

        totalTax = totalTax.add(salesTax).add(importTax);
        totalTax = roundToNearestNickel(totalTax);
    }

    /**
     * round(x / precision)) * precision
     * @param value
     * @return
     */
    private BigDecimal roundToNearestNickel(BigDecimal value) {
        // divide the value by the precision and then ceil the value.
        // then convert to a String to create a BigDecimal
        // (BigDecimal(String) is the preferred constructor).
        String roundedValueStr = String.valueOf(Math.ceil(value.divide(ROUNDING_PRECISION).doubleValue()));
        BigDecimal roundedValue = new BigDecimal(roundedValueStr).multiply(ROUNDING_PRECISION);

        return roundedValue;
    }

    /**
     * @return the salesTax
     */
    public BigDecimal getSalesTax() {
        return salesTax;
    }

    /**
     * @param salesTax the salesTax to set
     */
    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    /**
     * @return the importTax
     */
    public BigDecimal getImportTax() {
        return importTax;
    }

    /**
     * @param importTax the importTax to set
     */
    public void setImportTax(BigDecimal importTax) {
        this.importTax = importTax;
    }
}
