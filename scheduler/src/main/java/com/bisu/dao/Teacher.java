/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.Faculties;

/**
 *
 * @author ivankrister
 */
public class Teacher extends AbstractModel {
    
    public Teacher() {
        super(Faculties.class);
    }
    
}
