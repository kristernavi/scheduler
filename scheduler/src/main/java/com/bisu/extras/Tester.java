/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.extras;

import com.bisu.dao.SchoolYear;
import java.util.Calendar;

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
        int year = Calendar.getInstance().get(Calendar.YEAR);
        System.err.println(""+year);
        
        SchoolYear yr = new SchoolYear();
        System.out.println(""+yr.getActive().getSemester());
    }
    
}
