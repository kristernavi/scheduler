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
@Table(name = "subjects",
        catalog = "bisu_db",
        uniqueConstraints = @UniqueConstraint(columnNames = "code")
)
public class Subjects implements java.io.Serializable {

    private Integer id;
    private Courses courses;
    private Subjects subjects;
    private String description;
    private String code;
    private short yearLevel;
    private short semester;
    private short units;
    private Integer lecHours;
    private Integer labHours;
    private String type;
    private String preRequisite;
    private Set<Subjects> subjectses = new HashSet<Subjects>(0);
    private Set<TeachersLoadings> teachersLoadingses = new HashSet<TeachersLoadings>(0);
    private Set<SubjectDepartments> subjectDepartmentses = new HashSet<SubjectDepartments>(0);
    private Set<SubjectCourses> subjectCourseses = new HashSet<SubjectCourses>(0);

    public Subjects() {
    }

    public Subjects(String description, String code, short yearLevel, short semester, short units, String type) {
        this.description = description;
        this.code = code;
        this.yearLevel = yearLevel;
        this.semester = semester;
        this.units = units;
        this.type = type;
    }

    public Subjects(Courses courses, Subjects subjects, String description, String code, short yearLevel, short semester, short units, Integer lecHours, Integer labHours, String type, Set<Subjects> subjectses, Set<TeachersLoadings> teachersLoadingses) {
        this.courses = courses;
        this.subjects = subjects;
        this.description = description;
        this.code = code;
        this.yearLevel = yearLevel;
        this.semester = semester;
        this.units = units;
        this.lecHours = lecHours;
        this.labHours = labHours;
        this.type = type;
        this.subjectses = subjectses;
        this.teachersLoadingses = teachersLoadingses;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    public Courses getCourses() {
        return this.courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pre_requisite_id")
    public Subjects getSubjects() {
        return this.subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @NotBlank
    @Size(min = 2, max = 15)
    @Column(name = "code", unique = true, nullable = false)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Min(value = 1)
    @Max(value = 99)
    @Column(name = "year_level", nullable = false)
    public short getYearLevel() {
        return this.yearLevel;
    }

    public void setYearLevel(short yearLevel) {
        this.yearLevel = yearLevel;
    }

    @NotNull
    @Digits(integer = 1, fraction = 0)
    @Min(value = 1)
    @Max(value = 2)
    @Column(name = "semester", nullable = false)
    public short getSemester() {
        return this.semester;
    }

    public void setSemester(short semester) {
        this.semester = semester;
    }

    @NotNull
    @Digits(integer = 2, fraction = 0)
    @Min(value = 1)
    @Max(value = 99)
    @Column(name = "units", nullable = false)
    public short getUnits() {
        return this.units;
    }

    public void setUnits(short units) {
        this.units = units;
    }

    @Digits(integer = 2, fraction = 0)
    @Min(value = 0)
    @Max(value = 99)
    @Column(name = "lec_hours")
    public Integer getLecHours() {
        return this.lecHours;
    }

    public void setLecHours(Integer lecHours) {
        this.lecHours = lecHours;
    }

    @Digits(integer = 2, fraction = 0)
    @Min(value = 0)
    @Max(value = 1000)
    @Column(name = "lab_hours")
    public Integer getLabHours() {
        return this.labHours;
    }

    public void setLabHours(Integer labHours) {
        this.labHours = labHours;
    }

    @NotNull
    @NotBlank
    @Size(min = 0, max = 30)
    @Column(name = "type", nullable = false, length = 8)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Size(min = 1, max = 99)
    @Column(name = "pre_requisite", nullable = true, length = 8)
    public String getPreRequisite() {
        return preRequisite;
    }

    public void setPreRequisite(String preRequisite) {
        this.preRequisite = preRequisite;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subjects")
    public Set<Subjects> getSubjectses() {
        return this.subjectses;
    }

    public void setSubjectses(Set<Subjects> subjectses) {
        this.subjectses = subjectses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subjects")
    public Set<TeachersLoadings> getTeachersLoadingses() {
        return this.teachersLoadingses;
    }

    public void setTeachersLoadingses(Set<TeachersLoadings> teachersLoadingses) {
        this.teachersLoadingses = teachersLoadingses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subjects")
    public Set<SubjectDepartments> getSubjectDepartmentses() {
        return this.subjectDepartmentses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subjects")
    public Set<SubjectCourses> getSubjectCourseses() {
        return this.subjectCourseses;
    }

    public void setSubjectCourseses(Set<SubjectCourses> subjectCourseses) {
        this.subjectCourseses = subjectCourseses;
    }

    public void setSubjectDepartmentses(Set<SubjectDepartments> subjectDepartmentses) {
        this.subjectDepartmentses = subjectDepartmentses;
    }

}
