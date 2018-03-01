/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.Courses;
import com.bisu.entities.SubjectCourses;
import com.bisu.entities.Subjects;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author ANGGIE
 */
public class Subject extends AbstractModel{

    public Subject() {
        super(Subjects.class);
    }
    
    public List loading_course(Integer year_level, Integer semester,List<Integer> sc) {
        
        List results;
        begin();
        
        Criteria cr = session().createCriteria(Subjects.class);
        cr.add(Restrictions.eq("yearLevel", year_level.shortValue()));
        cr.add(Restrictions.eq("semester", semester.shortValue()));
        cr.add(Restrictions.in("id", sc));
        results = cr.list();
        
        

        end();
        return results;
    }
    
    public List<Subjects> getSubjectByCourse(List<Integer> sc){
         List results;
        begin();
        
        Criteria cr = session().createCriteria(Subjects.class);
        cr.add(Restrictions.in("id", sc));
        results = cr.list();
        

        end();
        return results;
        
    }
    
    public List getBySubjectCourse(List<Integer> sc) {
        
        List results;
        begin();
        
        Criteria cr = session().createCriteria(Subjects.class);
        cr.add(Restrictions.in("id", sc));
        
        results = cr.list();
        
        

        end();
        return results;
    }
     
   
    
}
