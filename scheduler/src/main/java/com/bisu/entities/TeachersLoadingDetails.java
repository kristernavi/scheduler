package com.bisu.entities;



import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ANGGIE
 */
@Entity
@Table(name="teachers_loading_details"
    ,catalog="bisu_db"
)
public class TeachersLoadingDetails  implements java.io.Serializable {


     private Integer id;
     private TeachersLoadings teachersLoadings;
     private Date hourStart;
     private Date hourEnd;
     private Rooms room;
     private boolean m;
     private boolean t;
     private boolean w;
     private boolean th;
     private boolean f;
     private String section;
     private Set<LoadCourses> loadCourseses = new HashSet<LoadCourses>(0);


    public TeachersLoadingDetails() {
    }

	
    public TeachersLoadingDetails(TeachersLoadings teachersLoadings, boolean m, boolean t, boolean w, boolean th, boolean f) {
        this.teachersLoadings = teachersLoadings;
        this.m = m;
        this.t = t;
        this.w = w;
        this.th = th;
        this.f = f;
    }
    public TeachersLoadingDetails(TeachersLoadings teachersLoadings, int roomId, Date hourStart, Date hourEnd, boolean m, boolean t, boolean w, boolean th, boolean f) {
       this.teachersLoadings = teachersLoadings;
       this.hourStart = hourStart;
       this.hourEnd = hourEnd;
       this.m = m;
       this.t = t;
       this.w = w;
       this.th = th;
       this.f = f;
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
    @JoinColumn(name="loading_id", nullable=false)
    public TeachersLoadings getTeachersLoadings() {
        return this.teachersLoadings;
    }
    
    public void setTeachersLoadings(TeachersLoadings teachersLoadings) {
        this.teachersLoadings = teachersLoadings;
    }

    
  

    @Temporal(TemporalType.TIME)
    @Column(name="hour_start", length=8)
    public Date getHourStart() {
        return this.hourStart;
    }
    
    public void setHourStart(Date hourStart) {
        this.hourStart = hourStart;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="hour_end", length=8)
    public Date getHourEnd() {
        return this.hourEnd;
    }
    
    public void setHourEnd(Date hourEnd) {
        this.hourEnd = hourEnd;
    }

    
    @Column(name="M", nullable=false)
    public boolean isM() {
        return this.m;
    }
    
    public void setM(boolean m) {
        this.m = m;
    }

    
    @Column(name="T", nullable=false)
    public boolean isT() {
        return this.t;
    }
    
    public void setT(boolean t) {
        this.t = t;
    }

    
    @Column(name="W", nullable=false)
    public boolean isW() {
        return this.w;
    }
    
    public void setW(boolean w) {
        this.w = w;
    }

    
    @Column(name="Th", nullable=false)
    public boolean isTh() {
        return this.th;
    }
    
    public void setTh(boolean th) {
        this.th = th;
    }

    
    @Column(name="F", nullable=false)
    public boolean isF() {
        return this.f;
    }
    
    public void setF(boolean f) {
        this.f = f;
    }
    
    @Column(name="section", nullable=true)
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    
    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="room_id", nullable=false)
    public Rooms getRooms() {
        return this.room;
    }
    
    public void setRooms(Rooms room) {
        this.room = room;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="teachersLoadingDetails")
    public Set<LoadCourses> getLoadCourseses() {
        return loadCourseses;
    }

    public void setLoadCourseses(Set<LoadCourses> loadCourseses) {
        this.loadCourseses = loadCourseses;
    }
    




}


