package net.proselyte.customerdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course extends BaseEntity{

    @Column(name = "name_course")
    private String name;


    @ManyToMany(mappedBy = "courses")
    private List<Student> students;



    // additional properties
    // standard constructors, getters, and setters
}