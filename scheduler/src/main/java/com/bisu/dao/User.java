/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.Faculties;
import com.bisu.entities.Users;
import com.bisu.extras.Helper;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ANGGIE
 */
public class User extends AbstractModel{
    
    public User() {
        super(Users.class);
    }
    
    public Users getByUsername(String username){
        
        try{
            begin();
        List results;
        
        Criteria cr = session().createCriteria(Users.class);
        cr.add(Restrictions.eq("username", username));
       
        results = cr.list();
        return (Users)results.get(0);
        
        }catch(Exception ex){
            Helper.errorMessage("Invalid Credentails", "Whoopss!");
            return null;
        }
        finally{
            end();
        }
    
    
    }
    
}
