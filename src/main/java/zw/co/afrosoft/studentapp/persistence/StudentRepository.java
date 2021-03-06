package zw.co.afrosoft.studentapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import zw.co.afrosoft.studentapp.domain.Address;
import zw.co.afrosoft.studentapp.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String firstname);
    Student findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findByFirstNameContains(String firstName);
    List<Student> findByFirstNameStartsWith(String firstName);
    List<Student> findByAddressCity(String city);

    //JPQL
    /*
    @Query("From Student where firstName = :firstName and lastName = : lastName")
    Student getByFirstNameAndLastName(String firstName, String lastName);
     */
   /*
   @Modifying
    @Transactional
    @Query("Update Student set firstName =:firstName where id =:Id")
    void updateFirstName(Long id ,String firstName);
    */
}
