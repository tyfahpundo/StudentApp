package zw.co.afrosoft.studentapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.studentapp.response.StudentResponse;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
    @Value("${app.name:Default StudApp}")
    private String appName;

    @GetMapping("/get")
    public StudentResponse getStudent(){
        StudentResponse response = new StudentResponse(1, "Tyfah","Pundo");
        return response;
    }
}
