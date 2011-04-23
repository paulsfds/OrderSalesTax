/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boku;

import boku.model.Good;
import java.util.List;

/**
 *
 * @author wongp3
 */
public class Receipt {

    private ShoppingBasket sb;

    public Receipt(ShoppingBasket sb) {
        this.sb = sb;
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        List<Good> goods = sb.getGoods();
        for (Good good : goods) {
            receipt.append(good.toString());
            receipt.append("\n");
        }
        receipt.append("Sales Taxes: ").append(sb.getTotalSalesTax()).append("\n");
        receipt.append("Total: ").append(sb.getTotalPrice());

        return receipt.toString();
    }

    public void print() {
        System.out.println(toString());
    }
}
