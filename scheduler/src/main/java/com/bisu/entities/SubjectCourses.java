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
@Table(name="subject_courses"
    ,catalog="bisu_db"
)
public class SubjectCourses  implements java.io.Serializable {


     private Integer id;
     private Courses courses;
     private Subjects subjects;
    

    public SubjectCourses() {
    }

	
    public SubjectCourses(Courses courses, Subjects subjects) {
        this.courses = courses;
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
    @JoinColumn(name="course_id", nullable=false)
    public Courses getCourses() {
        return this.courses;
    }
    
    public void setCourses(Courses courses) {
        this.courses = courses;
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


