/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ANGGIE
 */

@Entity
@Table(name="subject_departments"
    ,catalog="bisu_db"
)
public class SubjectDepartments implements java.io.Serializable{
    
     private Integer id;
     private Departments departments;
     private Subjects subjects;

    public SubjectDepartments() {
    }

    public SubjectDepartments(Departments departments, Subjects subjects) {
       this.departments = departments;
       this.subjects = subjects;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id", nullable=false)
    public Departments getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="subject_id", nullable=false)
    public Subjects getSubjects() {
        return this.subjects;
    }
    
    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }


    
}
