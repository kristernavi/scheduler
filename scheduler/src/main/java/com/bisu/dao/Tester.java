/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.entities.Departments;
import com.bisu.entities.Rooms;
import com.bisu.entities.Subjects;
import com.bisu.extras.Helper;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author ivankrister
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Subjects s = new Subjects();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();

        //...
        Set<ConstraintViolation<Subjects>> constraintViolations = validator.validate(s);
        System.out.println(constraintViolations);
        
        Course c = new Course();
        
        System.err.println(""+c.all().size());
        
    }
    
}
