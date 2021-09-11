package zw.co.afrosoft.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.studentapp.domain.Student;
import zw.co.afrosoft.studentapp.request.CreateStudentRequest;
import zw.co.afrosoft.studentapp.request.UpdateStudentRequest;
import zw.co.afrosoft.studentapp.response.StudentResponse;
import zw.co.afrosoft.studentapp.service.StudentService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("getAll")
    public List<StudentResponse> getAllStudents (){
        List<Student> studentList = service.getAllStudents();
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add( new StudentResponse(student));
        });
        return studentResponseList;
    }
    @PostMapping("create")
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        Student student = service.createStudent(createStudentRequest);
        return new StudentResponse(student);
    }
    @PutMapping("update")
    public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest){
        Student student = service.updateStudent(updateStudentRequest);

        return new StudentResponse(student);
    }
    @DeleteMapping("delete")
    public String deleteStudent(@RequestParam Long id){
        return service.deleteStudent(id);
    }
    @GetMapping("getByFirstname/{firstName}")
    public List<StudentResponse> getStudentByFirstname(@PathVariable String firstName){
        List<Student> studentList = service.getByFirstName(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
    @GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
    public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName,@PathVariable String lastName){
        return new StudentResponse(service.getSTudentByFirstNameAndLastName(firstName,lastName));
    }
    @GetMapping("like/{firstName}")
    public List<StudentResponse> getByFirstNameContains(@PathVariable String firstName){
        List<Student> studentList = service.getByFirstNameContains(firstName);

        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
    @GetMapping("startsWith/{firstName}")
    public List<StudentResponse> getByFirstNameStartsWith(@PathVariable String firstName) {
        List<Student> studentList = service.getByFirstNameStartsWith(firstName);

        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
    @GetMapping("getByCity/{city}")
    public List<StudentResponse> getByCity(@PathVariable String city){
        List<Student> studentList = service.getByAddress(city);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }

}
