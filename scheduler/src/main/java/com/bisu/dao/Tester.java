/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.entities.Courses;
import com.bisu.entities.Departments;
import com.bisu.entities.Rooms;
import com.bisu.entities.Subjects;
import com.bisu.extras.Helper;
import java.util.List;
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
//        Subjects s = new Subjects();
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//
//        Validator validator = factory.getValidator();
//
//        //...
//        Set<ConstraintViolation<Subjects>> constraintViolations = validator.validate(s);
//        System.out.println(constraintViolations);
//        
//        Course c = new Course();
//        
//        System.err.println(""+c.all().size());

//        SubjectDepartment sd = new SubjectDepartment();
//        Department department = new Department();
//        Departments dept = (Departments) department.find(1);
//        System.out.println(""+sd.getByDepartment(dept).size());

          SubjectCourse sc = new SubjectCourse();
          Course course = new Course();
          Courses c = (Courses) course.find(1);
          for(Integer i: sc.getByCourse(c)){
          System.out.println("Result: "+i+"\n");
          
          }
        Subject subject = new Subject();
          
        System.out.println(""+subject.getBySubjectCourse(sc.getByCourse(c)).size());
         List subjects = subject.loading_course(1, 1, sc.getByCourse(c));
        System.out.println("" + subjects.size());
          
        
    }
    
}
