package zw.co.afrosoft.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.studentapp.domain.Address;
import zw.co.afrosoft.studentapp.domain.Student;
import zw.co.afrosoft.studentapp.domain.Subject;
import zw.co.afrosoft.studentapp.persistence.AddressRepository;
import zw.co.afrosoft.studentapp.persistence.StudentRepository;
import zw.co.afrosoft.studentapp.persistence.SubjectRepository;
import zw.co.afrosoft.studentapp.request.CreateStudentRequest;
import zw.co.afrosoft.studentapp.request.CreateSubjectRequest;
import zw.co.afrosoft.studentapp.request.UpdateStudentRequest;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public List<Student>getAllStudents(){
        return studentRepository.findAll();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student(createStudentRequest);

        Address address = new Address();
        address.setStreet(createStudentRequest.getStreet());
        address.setCity(createStudentRequest.getCity());

        address = addressRepository.save(address);

        student.setAddress(address);
        student = studentRepository.save(student);

        List<Subject> subjectList = new ArrayList<>();
        if(createStudentRequest.getSubjects() != null){
            for(CreateSubjectRequest createSubjectRequest : createStudentRequest.getSubjects()){
                Subject subject = new Subject();
                subject.setSubjectName(createSubjectRequest.getSubjectName());
                subject.setMarksObtained(createSubjectRequest.getMarksObtained());
                subject.setStudent(student);

                subjectList.add(subject);
            }
            subjectRepository.saveAll(subjectList);
        }
        student.setSubjects(subjectList);
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
    public List<Student> getByFirstNameContains(String firstName){

        return studentRepository.findByFirstNameContains(firstName);
    }
    public List<Student> getByFirstNameStartsWith(String firstName){

        return studentRepository.findByFirstNameStartsWith(firstName);
    }
    public List<Student> getByAddress(String city){
        return studentRepository.findByAddressCity(city);
    }
}
