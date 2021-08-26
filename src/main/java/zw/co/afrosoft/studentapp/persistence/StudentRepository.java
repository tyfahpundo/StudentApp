package zw.co.afrosoft.studentapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.studentapp.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
