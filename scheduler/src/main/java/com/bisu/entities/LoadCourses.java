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
 * @author ivankrister
 */
@Entity
@Table(name = "load_courses",
         catalog = "bisu_db"
)
public class LoadCourses implements java.io.Serializable {

    private Integer id;
    private TeachersLoadingDetails teachersLoadingDetails;
    private Courses courses;

    public LoadCourses() {
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="load_detail_id", nullable=false)
    public TeachersLoadingDetails getTeachersLoadingDetails() {
        return teachersLoadingDetails;
    }

    public void setTeachersLoadingDetails(TeachersLoadingDetails teachersLoadingDetails) {
        this.teachersLoadingDetails = teachersLoadingDetails;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="course_id", nullable=false)
    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
    
    

}
