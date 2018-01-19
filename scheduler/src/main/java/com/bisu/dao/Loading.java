/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.Departments;
import com.bisu.entities.Faculties;
import com.bisu.entities.SchoolYears;
import com.bisu.entities.Subjects;
import com.bisu.entities.TeachersLoadings;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivankrister
 */
public class Loading extends AbstractModel{
    
    public Loading() {
        super(TeachersLoadings.class);
    }
    
    public List getByInstructor(Faculties instructor)
    {
       List results;
        begin();
        
        Criteria cr = session().createCriteria(TeachersLoadings.class);
        cr.add(Restrictions.eq("faculties", instructor));
       
        results = cr.list();
        end();
        return results;
    }
    
    public List<TeachersLoadings> classRoomData(SchoolYears schoolYear, List<Subjects> subjects){
        
        List results;
        begin();
        Criteria cr = session().createCriteria(TeachersLoadings.class);
        cr.add(Restrictions.in("subjects", subjects));
        cr.add(Restrictions.eq("schoolYears", schoolYear));
        results = cr.list();
        end();
        return results;
        
    }
    
}
