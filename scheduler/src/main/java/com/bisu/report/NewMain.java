/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.report;

import java.io.File;

/**
 *
 * @author ivankrister
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         String userHomeDirectory = System.getProperty("user.home");
            /* Output file location */
         String outputFile = userHomeDirectory + File.separatorChar + "JasperTableExample.pdf";
         System.out.println(""+outputFile);
    }
    
}
