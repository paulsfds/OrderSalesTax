/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boku;

import java.util.List;

/**
 *
 * @author wongp3
 */
public interface Reader<T> {
    public List<T> readFromFile(String fileName);
}
