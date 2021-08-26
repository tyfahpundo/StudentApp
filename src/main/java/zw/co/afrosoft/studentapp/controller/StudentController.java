package zw.co.afrosoft.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.studentapp.domain.Student;
import zw.co.afrosoft.studentapp.response.StudentResponse;
import zw.co.afrosoft.studentapp.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/getAll")
    public List<StudentResponse> getAllStudents (){
        List<Student> studentList = service.getAllStudents();
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
           studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }
}
