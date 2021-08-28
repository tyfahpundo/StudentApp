package zw.co.afrosoft.studentapp.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateStudentRequest {
    @JsonProperty("first_name")
    @NotBlank(message = "First name is a requirement!")
    private String firstName;

    private String lastName;
    private String email;
}
