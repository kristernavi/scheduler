/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.SchoolYears;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ANGGIE
 */
public class SchoolYear extends AbstractModel {

    public SchoolYear() {
        super(SchoolYears.class);
    }

    public SchoolYears getActive() {

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

    public void setAllInactive() {
        begin();
        Query query = session().createSQLQuery(
                "UPDATE school_years SET actived = 0 WHERE id > 0");
        query.executeUpdate();
        end();
    }
    
    public SchoolYears getYear(Integer yearStart, Integer yearEnd, Short semester){
        
        SchoolYears sy;
        List result;
        begin();

        Criteria cr = session().createCriteria(SchoolYears.class);
        cr.add(Restrictions.eq("yearStart", yearStart));
        cr.add(Restrictions.eq("yearEnd", yearEnd));
        cr.add(Restrictions.eq("semester", semester));
        result = cr.list();

        end();
        if(result.size() > 0){
            sy = (SchoolYears) result.get(0);
        }else{
            sy = new SchoolYears();

        }
        return sy;
        
    }

}
