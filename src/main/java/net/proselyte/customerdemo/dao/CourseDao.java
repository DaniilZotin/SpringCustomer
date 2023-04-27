package net.proselyte.customerdemo.dao;

import lombok.*;
import net.proselyte.customerdemo.model.Course;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDao {

    private String name;

    private List<StudentDao> studentDaoList;

    public static CourseDao toModel(Course course){
        CourseDao courseDao = new CourseDao();
        courseDao.setName(course.getName());
        courseDao.setStudentDaoList(course.getStudents().stream().map(StudentDao::toModel).collect(Collectors.toList()));
        return courseDao;
    }
}
