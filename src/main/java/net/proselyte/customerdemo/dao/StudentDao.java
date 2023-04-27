package net.proselyte.customerdemo.dao;

import lombok.*;
import net.proselyte.customerdemo.model.Course;
import net.proselyte.customerdemo.model.Student;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter

public class StudentDao {

    private String name;

    private List<CourseDao> courseDaoList;

    public static StudentDao toModel(Student student){
        StudentDao studentDao = new StudentDao();
        studentDao.setName(student.getName());
        //studentDao.setCourseDaoList(student.getCourses().stream().map(CourseDao::toModel).collect(Collectors.toList()));
        return studentDao;
    }
}
