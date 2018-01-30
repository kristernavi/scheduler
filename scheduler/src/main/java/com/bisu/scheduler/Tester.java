/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

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
         hasConflict(1,1,new Date(),new Date(),true,true,false,false,false);
       
    }
    
    public static void hasConflict(Integer schoolYear, Integer room, Date hr_start , Date hr_end,boolean m, boolean t, boolean w, boolean th, boolean f) {
        
        java.sql.Time sqlStart = new java.sql.Time(hr_start.getTime());
        java.sql.Time sqlEnd = new java.sql.Time(hr_end.getTime());

        String query_string = "SELECT * from teachers_loadings JOIN teachers_loading_details ON teachers_loadings.id = teachers_loading_details.loading_id ";
        
        query_string = query_string+"WHERE teachers_loadings.school_year_id = "+schoolYear;
        
        query_string = query_string+" AND teachers_loading_details.room_id = "+room;
        query_string = query_string+" AND teachers_loadings.school_year_id = "+schoolYear;
        query_string = query_string+" AND ((teachers_loading_details.hour_start <= '"+ sqlStart+"'";
        query_string = query_string+" AND teachers_loading_details.hour_end >= '"+sqlStart+"')";
        query_string = query_string+" OR (teachers_loading_details.hour_start <= '"+sqlEnd+"'";
        query_string = query_string+" OR teachers_loading_details.hour_end >= '"+sqlEnd+"')) AND";


        if (m) {
            query_string = query_string+" teachers_loading_details.M = 1 OR";
        }
        if (t) {
            query_string = query_string+" teachers_loading_details.T = 1 OR";
        }
        if (w) {
            query_string = query_string+" teachers_loading_details.W = 1 OR";
        }
        if (th) {
            query_string = query_string+" teachers_loading_details.Th = 1 OR";
        }
        if (f) {
            query_string = query_string+" teachers_loading_details.F = 1 OR";
        }
        
        query_string = StringUtils.removeEnd(query_string, "OR");
        

        System.err.println(""+query_string);
    }
    
}
