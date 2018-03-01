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

/**
 *
 * @author ANGGIE
 */
@Entity
@Table(name="teachers_loadings"
    ,catalog="bisu_db"
)
public class TeachersLoadings  implements java.io.Serializable {


     private Integer id;
     private Faculties faculties;
     private SchoolYears schoolYears;
     private Subjects subjects;
     private Set<TeachersLoadingDetails> teachersLoadingDetailses = new HashSet<TeachersLoadingDetails>(0);
     private Integer times;
    public TeachersLoadings() {
    }

	
    public TeachersLoadings(Faculties faculties, SchoolYears schoolYears, Subjects subjects) {
        this.faculties = faculties;
        this.schoolYears = schoolYears;
        this.subjects = subjects;
    }
    public TeachersLoadings(Faculties faculties, SchoolYears schoolYears, Subjects subjects, Set<TeachersLoadingDetails> teachersLoadingDetailses) {
       this.faculties = faculties;
       this.schoolYears = schoolYears;
       this.subjects = subjects;
       this.teachersLoadingDetailses = teachersLoadingDetailses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
   @Column(name="times", nullable=true)
    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
    
    

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="teacher_id", nullable=false)
    public Faculties getFaculties() {
        return this.faculties;
    }
    
    public void setFaculties(Faculties faculties) {
        this.faculties = faculties;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="school_year_id", nullable=false)
    public SchoolYears getSchoolYears() {
        return this.schoolYears;
    }
    
    public void setSchoolYears(SchoolYears schoolYears) {
        this.schoolYears = schoolYears;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="subject_id", nullable=false)
    public Subjects getSubjects() {
        return this.subjects;
    }
    
    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="teachersLoadings")
    public Set<TeachersLoadingDetails> getTeachersLoadingDetailses() {
        return this.teachersLoadingDetailses;
    }
    
    public void setTeachersLoadingDetailses(Set<TeachersLoadingDetails> teachersLoadingDetailses) {
        this.teachersLoadingDetailses = teachersLoadingDetailses;
    }




}


