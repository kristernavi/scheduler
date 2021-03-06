package com.bisu.entities;



import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ANGGIE
 */
@Entity
@Table(name="school_years"
    ,catalog="bisu_db"
)
public class SchoolYears  implements java.io.Serializable {


     private Integer id;
     private int yearStart;
     private int yearEnd;
     private short semester;
     private boolean actived;
     private Set<TeachersLoadings> teachersLoadingses = new HashSet<TeachersLoadings>(0);

    public SchoolYears() {
    }

	
    public SchoolYears(short semester, boolean actived) {
        this.semester = semester;
        this.actived = actived;
    }
    public SchoolYears(short semester, boolean actived, Set<TeachersLoadings> teachersLoadingses) {
       this.semester = semester;
       this.actived = actived;
       this.teachersLoadingses = teachersLoadingses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="year_start", nullable=false)
    public int getYearStart() {
        return this.yearStart;
    }
    
    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
    }
    
    @Column(name="year_end", nullable=false)
    public int getYearEnd() {
        return this.yearEnd;
    }
    
    public void setYearEnd(int yearEnd) {
        this.yearEnd = yearEnd;
    }

    
    @Column(name="semester", nullable=false)
    public short getSemester() {
        return this.semester;
    }
    
    public void setSemester(short semester) {
        this.semester = semester;
    }

    
    @Column(name="actived", nullable=false)
    public boolean isActived() {
        return this.actived;
    }
    
    public void setActived(boolean actived) {
        this.actived = actived;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="schoolYears")
    public Set<TeachersLoadings> getTeachersLoadingses() {
        return this.teachersLoadingses;
    }
    
    public void setTeachersLoadingses(Set<TeachersLoadings> teachersLoadingses) {
        this.teachersLoadingses = teachersLoadingses;
    }




}


