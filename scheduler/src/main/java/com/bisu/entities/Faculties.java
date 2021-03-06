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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ANGGIE
 */
@Entity
@Table(name="faculties"
    ,catalog="bisu_db"
    , uniqueConstraints = @UniqueConstraint(columnNames="prc_no") 
)
public class Faculties  implements java.io.Serializable {


     private Integer id;
     private Departments departments;
     private String prcNo;
     private String firstname;
     private String lastname;
     private String middlename;
     private String rank;
     private String designation;
     private String eligibility;
     private String specialization;
     private String degreeEarned;
     private String postDegree;
     private short minLoad;
     private short maxLoad;
     private Integer regularLoad;
     private Integer deloading;
     private Integer overload;
     private Set<TeachersLoadings> teachersLoadingses = new HashSet<TeachersLoadings>(0);

    public Faculties() {
    }

	
    public Faculties(String firstname, String lastname, short minLoad, short maxLoad) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.minLoad = minLoad;
        this.maxLoad = maxLoad;
    }
    public Faculties(Departments departments, String prcNo, String firstname, String lastname, String middlename, String rank, String designation, String eligibility, String specialization, String degreeEarned, String postDegree, short minLoad, short maxLoad, Set<TeachersLoadings> teachersLoadingses) {
       this.departments = departments;
       this.prcNo = prcNo;
       this.firstname = firstname;
       this.lastname = lastname;
       this.middlename = middlename;
       this.rank = rank;
       this.designation = designation;
       this.eligibility = eligibility;
       this.specialization = specialization;
       this.degreeEarned = degreeEarned;
       this.postDegree = postDegree;
       this.minLoad = minLoad;
       this.maxLoad = maxLoad;
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
@NotNull
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id")
    public Departments getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    
    @Column(name="prc_no", unique=true)
    public String getPrcNo() {
        return this.prcNo;
    }
    
    public void setPrcNo(String prcNo) {
        this.prcNo = prcNo;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="firstname", nullable=false)
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="lastname", nullable=false)
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="middlename")
    public String getMiddlename() {
        return this.middlename;
    }
    
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="rank")
    public String getRank() {
        return this.rank;
    }
    
    public void setRank(String rank) {
        this.rank = rank;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="designation")
    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="eligibility")
    public String getEligibility() {
        return this.eligibility;
    }
    
    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="specialization")
    public String getSpecialization() {
        return this.specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="degree_earned")
    public String getDegreeEarned() {
        return this.degreeEarned;
    }
    
    public void setDegreeEarned(String degreeEarned) {
        this.degreeEarned = degreeEarned;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="post_degree")
    public String getPostDegree() {
        return this.postDegree;
    }
    
    public void setPostDegree(String postDegree) {
        this.postDegree = postDegree;
    }

    
    @Column(name="min_load", nullable=false)
    public short getMinLoad() {
        return this.minLoad;
    }
    
    public void setMinLoad(short minLoad) {
        this.minLoad = minLoad;
    }

    
    @Column(name="max_load", nullable=false)
    public short getMaxLoad() {
        return this.maxLoad;
    }
    
    public void setMaxLoad(short maxLoad) {
        this.maxLoad = maxLoad;
    }
    @NotNull
    @Digits(integer = 3,  fraction = 0)
    @Min(value = 0)
    @Max(value = 100)
    @Column(name="overload", nullable=false)
    public Integer getOverload() {
        return this.overload;
    }
    
    public void setOverload(Integer overload) {
        this.overload = overload;
    }
    @NotNull
    @Digits(integer = 3,  fraction = 0)
    @Min(value = 1)
    @Max(value = 100)
    @Column(name="regular_load", nullable=false)
    public Integer getRegularLoad() {
        return this.regularLoad;
    }
    
    public void setRegularLoad(Integer regularLoad) {
        this.regularLoad = regularLoad;
    }
    @NotNull
    @Digits(integer = 3,  fraction = 0)
    @Min(value = 0)
    @Max(value = 100)
    @Column(name="deloading", nullable=false)
    public Integer getDeloading() {
        return this.deloading;
    }
    
    public void setDeloading(Integer deloading) {
        this.deloading = deloading;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="faculties")
    public Set<TeachersLoadings> getTeachersLoadingses() {
        return this.teachersLoadingses;
    }
    
    public void setTeachersLoadingses(Set<TeachersLoadings> teachersLoadingses) {
        this.teachersLoadingses = teachersLoadingses;
    }
    @Transient
    public String getFullname(){
    
        return this.getFirstname()+" "+this.getMiddlename()+ " "+this.getLastname();
    }




}


