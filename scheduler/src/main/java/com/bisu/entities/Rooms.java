package com.bisu.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 *
 * @author ANGGIE
 */
@Entity
@Table(name="rooms"
    ,catalog="bisu_db"
    , uniqueConstraints = @UniqueConstraint(columnNames="number") 
)
public class Rooms  implements java.io.Serializable {


     private Integer id;
     private String description;
     private String location;
     private String type;
     private int capacity;
     private int number;

    public Rooms() {
    }

    public Rooms(String description, String location, String type, int capacity, int number) {
       this.description = description;
       this.location = location;
       this.type = type;
       this.capacity = capacity;
       this.number = number;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    @Column(name="description", nullable=false)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    @Column(name="location", nullable=false)
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }

    @NotBlank
    @NotNull
    @Column(name="type", nullable=false, length=10)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    @NotNull
    @Digits(integer = 3,  fraction = 0)
    @Min(value = 1)
    @Max(value = 100)
    @Column(name="capacity", nullable=false)
    public int getCapacity() {
        return this.capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @NotNull
    @Digits(integer = 5,  fraction = 0)
    @Min(value = 1)
    @Column(name="number", unique=true, nullable=false)
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }




}


