package zw.co.afrosoft.studentapp.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateStudentRequest {
    @NotNull(message = "Student id is required")
    private long id;

    private String firstName;
    private String lastName;
    private String email;
}
