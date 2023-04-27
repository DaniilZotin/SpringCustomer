package net.proselyte.customerdemo.repo;

import net.proselyte.customerdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findStudentsByCoursesId(Long courseId);
}
