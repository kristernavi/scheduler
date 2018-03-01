/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.Rooms;
import com.bisu.entities.TeachersLoadingDetails;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ANGGIE
 */
public class LoadingDetail extends AbstractModel {

    public LoadingDetail() {
        super(TeachersLoadingDetails.class);
    }
    
    public List<TeachersLoadingDetails> getByRoom(Rooms room){
        List<TeachersLoadingDetails> results;
         begin();
        
        Criteria cr = session().createCriteria(TeachersLoadingDetails.class);
        cr.add(Restrictions.eq("rooms", room));
        results = cr.list();
        

        end();
        return results;
        
    }
    
    

}
