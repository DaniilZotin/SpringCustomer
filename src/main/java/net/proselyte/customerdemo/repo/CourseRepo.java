package net.proselyte.customerdemo.repo;


import net.proselyte.customerdemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {
    List<Course> findCourseByStudentsId(Long studentId);
    List<Course> findCourseByName(String name);
}
