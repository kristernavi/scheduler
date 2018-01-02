/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.SchoolYears;
import com.bisu.entities.Subjects;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivankrister
 */
public class SchoolYear extends AbstractModel {

    public SchoolYear() {
        super(SchoolYears.class);
    }
    
    public SchoolYears getActive(){
    
        List result;
        begin();
        
        Criteria cr = session().createCriteria(SchoolYears.class);
        cr.add(Restrictions.eq("actived", true));
        cr.setFirstResult(0);
        cr.setMaxResults(1);
        result = cr.list();
        

        end();
        return (SchoolYears) result.get(0);
    }
    
}
