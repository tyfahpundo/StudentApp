package zw.co.afrosoft.studentapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.studentapp.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

}
