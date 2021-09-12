package zw.co.afrosoft.studentapp.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.studentapp.domain.Student;
import zw.co.afrosoft.studentapp.domain.Subject;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentResponse {
    private long id;
    @JsonProperty("first_name")
    private String firstName;
    private String lastName;
    private String email;
    private String fullName;
    private String street;
    private String city;
    private List<SubjectResponse> subjects;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.fullName = student.getFirstName() + " " + student.getLastName();

        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();

        if(student.getSubjects() != null){
            subjects = new ArrayList<>();
            for(Subject subject : student.getSubjects()) {
                subjects.add(new SubjectResponse(subject));
            }
        }

    }

}
