/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boku;

import boku.model.Good;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wongp3
 */
public class GoodReader implements Reader<Good> {
    public List<Good> readFromFile(String fileName) {
        List<Good> goods = new ArrayList<Good>();

        try {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException ex) {
                System.err.println("File could not be opened!");
            }

            String line = null;
            while ((line = br.readLine()) != null) {
                goods.add(GoodFactory.getGood(line));
            }

            br.close();
        } catch (IOException ex) {
            Logger.getLogger(GoodReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return goods;
    }
}
