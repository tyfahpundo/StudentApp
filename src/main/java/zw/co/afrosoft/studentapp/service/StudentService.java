package zw.co.afrosoft.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.studentapp.domain.Student;
import zw.co.afrosoft.studentapp.persistence.StudentRepository;
import zw.co.afrosoft.studentapp.request.CreateStudentRequest;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
       return studentRepository.findAll();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student(createStudentRequest);
        student = studentRepository.save(student);
        return student;
    }
}
