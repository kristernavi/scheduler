/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.Departments;
import com.bisu.entities.SubjectDepartments;
import com.bisu.entities.Subjects;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivankrister
 */
public class SubjectDepartment extends AbstractModel{
    
    public SubjectDepartment() {
        super(SubjectDepartments.class);
    }
    
    public List getByDepartment(Departments departments){
        
        List results;
        begin();
        
        Criteria cr = session().createCriteria(SubjectDepartment.class);
        cr.add(Restrictions.eq("departments", departments));
        
        results = cr.list();

        end();
        return results;
    }
    
}
