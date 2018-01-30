/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ivankrister
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.MINUTE, 30);
        c.set(Calendar.SECOND, 0);
        Date d1 = (Date) c.getTime();
        Date d2 = new Date();
        System.err.println(""+d1.getTime());
       
    }
    
}
