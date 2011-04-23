/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boku;

/**
 *
 * @author wongp3
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("boku <filename>");
        } else {
            // "src/input/input1.txt"
        }
        GoodReader gr = new GoodReader();
        ShoppingBasket sb = new ShoppingBasket();
        sb.add(gr.readFromFile("src/input/input3.txt"));
        Receipt receipt = sb.purchase();
        receipt.print();
    }
}
