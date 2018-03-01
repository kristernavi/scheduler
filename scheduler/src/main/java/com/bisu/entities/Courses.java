package com.bisu.entities;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author ANGGIE
 */
@Entity
@Table(name="courses"
    ,catalog="bisu_db"
    , uniqueConstraints = @UniqueConstraint(columnNames="code") 
)
public class Courses  implements java.io.Serializable {


     private Integer id;
     private Departments departments;
     private String description;
     private String code;
     private Set<Subjects> subjectses = new HashSet<Subjects>(0);

    public Courses() {
    }

	
    public Courses(Departments departments, String description, String code) {
        this.departments = departments;
        this.description = description;
        this.code = code;
    }
    public Courses(Departments departments, String description, String code, Set<Subjects> subjectses) {
       this.departments = departments;
       this.description = description;
       this.code = code;
       this.subjectses = subjectses;
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

    
    @Column(name="description", nullable=false)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="code", unique=true, nullable=false)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="courses")
    public Set<Subjects> getSubjectses() {
        return this.subjectses;
    }
    
    public void setSubjectses(Set<Subjects> subjectses) {
        this.subjectses = subjectses;
    }




}


