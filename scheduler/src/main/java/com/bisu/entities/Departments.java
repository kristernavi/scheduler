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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ANGGIE
 */
@Entity
@Table(name = "departments",
         catalog = "bisu_db",
         uniqueConstraints = @UniqueConstraint(columnNames = {"code", "id"})
)
public class Departments implements java.io.Serializable {

    private Integer id;
    private String description;
    private String code;
    private String head;
    private Set<Faculties> facultieses = new HashSet<Faculties>(0);
    private Set<Courses> courseses = new HashSet<Courses>(0);
    private Set<SubjectDepartments> subjectDepartmentses = new HashSet<SubjectDepartments>(0);

    public Departments() {
    }

    public Departments(String description, String code, String head) {
        this.description = description;
        this.code = code;
        this.head = head;
    }

    public Departments(String description, String code, String head, Set<Faculties> facultieses, Set<Courses> courseses) {
        this.description = description;
        this.code = code;
        this.head = head;
        this.facultieses = facultieses;
        this.courseses = courseses;
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

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
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
    @NotBlank
    @Size(min = 2, max = 30)
    @Column(name = "head", nullable = false)
    public String getHead() {
        return this.head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departments")
    public Set<Faculties> getFacultieses() {
        return this.facultieses;
    }

    public void setFacultieses(Set<Faculties> facultieses) {
        this.facultieses = facultieses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departments")
    public Set<Courses> getCourseses() {
        return this.courseses;
    }

    public void setCourseses(Set<Courses> courseses) {
        this.courseses = courseses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departments")
    public Set<SubjectDepartments> getSubjectDepartmentses() {
        return this.subjectDepartmentses;
    }

    public void setSubjectDepartmentses(Set<SubjectDepartments> subjectDepartmentses) {
        this.subjectDepartmentses = subjectDepartmentses;
    }

}
