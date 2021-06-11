/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chippedanimals;

import chippedanimals.backend.*;
import chippedanimals.frontend.ListAnimalsFrame;

/**
 *
 * @author lunie
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            ListAnimalsFrame la = new ListAnimalsFrame();
            la.setSize(950, 700);
            la.setTitle("Chipped Animals Database");
            la.setVisible(true);
    }
    
}
