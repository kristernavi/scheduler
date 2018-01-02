/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.Courses;
import com.bisu.entities.Subjects;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author ivankrister
 */
public class Subject extends AbstractModel{

    public Subject() {
        super(Subjects.class);
    }
    
    public List loading_course(Integer year_level, Integer semester, Courses course) {
        
        List results;
        begin();
        
        Criteria cr = session().createCriteria(Subjects.class);
        cr.add(Restrictions.eq("yearLevel", year_level.shortValue()));
        cr.add(Restrictions.eq("semester", semester.shortValue()));
        cr.add(Restrictions.eq("courses", course));
        results = cr.list();
        
        

        end();
        return results;
    }
     
   
    
}
