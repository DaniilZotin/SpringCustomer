package net.proselyte.customerdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student extends BaseEntity{


    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @Column(name = "name_student")
    private String name;



}
