package zw.co.afrosoft.studentapp.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.afrosoft.studentapp.domain.Student;

@Getter
@Setter
public class StudentResponse {
    private long id;
    @JsonProperty("first_name")
    private String firstName;
    private String lastName;
    private String email;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
    }

}
