package zw.co.afrosoft.studentapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.afrosoft.studentapp.request.CreateStudentRequest;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Transient
    private String fullName;

    public Student(CreateStudentRequest createStudentRequest){
        this.firstName = createStudentRequest.getFirstName();
        this.lastName = createStudentRequest.getLastName();
        this.email = createStudentRequest.getEmail();
        this.fullName = createStudentRequest.getFirstName() + " " + createStudentRequest.getLastName();
    }
}
