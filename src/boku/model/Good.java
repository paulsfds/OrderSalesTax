/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boku.model;

import boku.GoodType;
import boku.Tax;
import java.math.BigDecimal;

/**
 *
 * @author wongp3
 */
public class Good {

    private int quantity;
    private String description;
    private GoodType type;
    private BigDecimal price;
    private Tax salesTax;
    private boolean isImported;

    public Good(int quantity, String description, BigDecimal price, boolean isImported) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.isImported = isImported;
        this.salesTax = new Tax(this);
    }

    public boolean isExempt() {
        return false;
    }

    public BigDecimal getTotal() {
        return this.price.add(this.salesTax.getTotalTax());
    }

    public void caculateSalesTax() {
        salesTax.calculate(this.price, isExempt(), this.isImported);
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the type
     */
    public GoodType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(GoodType type) {
        this.type = type;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the salesTax
     */
    public Tax getSalesTax() {
        return salesTax;
    }

    /**
     * @param salesTax the salesTax to set
     */
    public void setSalesTax(Tax salesTax) {
        this.salesTax = salesTax;
    }

    /**
     * @return the imported
     */
    public boolean isImported() {
        return isImported;
    }

    /**
     * @param imported the imported to set
     */
    public void setImported(boolean imported) {
        this.isImported = imported;
    }

    @Override
    public String toString() {
        // 1 chocolate bar: 0.85
        return this.quantity + " " + this.description + ": " + this.price;
    }
}
