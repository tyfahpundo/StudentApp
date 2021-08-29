package zw.co.afrosoft.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.studentapp.domain.Student;
import zw.co.afrosoft.studentapp.persistence.StudentRepository;
import zw.co.afrosoft.studentapp.request.CreateStudentRequest;
import zw.co.afrosoft.studentapp.request.UpdateStudentRequest;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student>getAllStudents(){
        return studentRepository.findAll();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student(createStudentRequest);
        student = studentRepository.save(student);
        return student;
    }
    public Student updateStudent(UpdateStudentRequest updateStudentRequest){
        Student student = studentRepository.findById(updateStudentRequest.getId()).get();

        if(updateStudentRequest.getFirstName() != null &&
                    !updateStudentRequest.getFirstName().isEmpty()){
            student.setFirstName(updateStudentRequest.getFirstName());
        }
        student = studentRepository.save(student);
        return student;
    }
    public String deleteStudent(Long id){
        studentRepository.deleteById(id);
        return "Student has been deleted successfully";
    }
    public List<Student> getByFirstName(String firstName){
        return studentRepository.findByFirstName(firstName);
    }
    public Student getSTudentByFirstNameAndLastName(String firstName, String lastName){
        return studentRepository.findByFirstNameAndLastName(firstName,lastName);
    }
}
