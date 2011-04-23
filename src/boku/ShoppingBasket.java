/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boku;

import boku.model.Good;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wongp3
 */
public class ShoppingBasket {

    private List<Good> goods;

    public ShoppingBasket() {
        this.goods = new ArrayList<Good>();
    }

    public void add(Good good) {
        goods.add(good);
    }

    public void add(List<Good> goods) {
        this.goods.addAll(goods);
    }

    public void remove(Good good) {
        goods.remove(good);
    }

    public void removeAll() {
        goods.clear();
    }

    public Receipt purchase() {
        for(Good good : goods) {
            good.getSalesTax().calculate(good.getPrice(), good.isExempt(), good.isImported());
        }
        Receipt receipt = new Receipt(this);

        return receipt;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public BigDecimal getTotalSalesTax() {
        BigDecimal totalSalesTax = new BigDecimal("0.0");
        for (Good good : goods) {
            totalSalesTax = totalSalesTax.add(good.getSalesTax().getTotalTax());
        }

        return totalSalesTax.setScale(2);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal("0.0");
        for (Good good : goods) {
            totalPrice = totalPrice.add(good.getTotal());
        }

        return totalPrice.setScale(2);
    }
}
