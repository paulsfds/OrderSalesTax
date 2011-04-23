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
public interface Item {
    public BigDecimal getTotalTax();
    public BigDecimal getTotal();
}
