/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.Courses;
import com.bisu.entities.LoadCourses;
import com.bisu.entities.SubjectCourses;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ANGGIE
 */
public class LoadCourse extends AbstractModel{
    
    public LoadCourse() {
        super(LoadCourses.class);
    }
    
    public List getByCourse(Courses course){
        
        List result;
        
        begin();
        
        Criteria cr = session().createCriteria(LoadCourses.class);
        cr.add(Restrictions.eq("courses", course));
        result = cr.list();

        end();
        
        
        return result;
    
    
    }
    
}
