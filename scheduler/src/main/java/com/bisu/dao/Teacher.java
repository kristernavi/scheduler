/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.Departments;
import com.bisu.entities.Faculties;
import com.bisu.entities.Subjects;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivankrister
 */
public class Teacher extends AbstractModel {
    
    public Teacher() {
        super(Faculties.class);
    }
    
    public List getByDepartment(Departments department)
    {
       List results;
        begin();
        
        Criteria cr = session().createCriteria(Faculties.class);
        cr.add(Restrictions.eq("departments", department));
       
        results = cr.list();
        end();
        return results;
    }
    
}
