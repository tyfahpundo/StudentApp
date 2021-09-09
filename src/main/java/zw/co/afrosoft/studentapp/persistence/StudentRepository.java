package zw.co.afrosoft.studentapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.studentapp.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String firstname);
    Student findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findByFirstNameContains(String firstName);
}
