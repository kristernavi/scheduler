/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.Courses;
import com.bisu.entities.Departments;
import com.bisu.entities.SubjectCourses;
import com.bisu.entities.Subjects;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ANGGIE
 */
public class SubjectCourse extends AbstractModel {
    
    public SubjectCourse() {
        super(SubjectCourses.class);
    }
    
    public List <Integer> getByCourse(Courses course){
        
        List <SubjectCourses> results;
        List <Integer> idList = new ArrayList();
        begin();
        
        Criteria cr = session().createCriteria(SubjectCourses.class);
        cr.add(Restrictions.eq("courses", course));
        
        
        results = cr.list();

        end();
        for(SubjectCourses r: results){
            idList.add(r.getSubjects().getId());
        }
        return idList;
    }
    
    public void deleteBySubject(Integer subject_id) {
        begin();
        Query query = session().createSQLQuery(
                "DELETE from subject_courses WHERE subject_id = "+subject_id);
        query.executeUpdate();
        end();
    }
    public List <SubjectCourses> getBySubject(Subjects subject){
        List <SubjectCourses> results;
        List <Integer> idList = new ArrayList();
        begin();
        
        Criteria cr = session().createCriteria(SubjectCourses.class);
        cr.add(Restrictions.eq("subjects", subject));
        
        
        results = cr.list();

        end();
        
        return results;
    }
    
}
