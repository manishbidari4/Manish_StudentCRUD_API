package student.crud.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.crud.springboot.exception.ResourceNotFoundException;
import student.crud.springboot.model.Student;
import student.crud.springboot.repository.StudentRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    // build create student REST API
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // build get student by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable  long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));
        return ResponseEntity.ok(student);
    }

    // build update student REST API
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student studentDetails) {
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));

        updateStudent.setName(studentDetails.getName());
        updateStudent.setContact(studentDetails.getContact());
        updateStudent.setAddress(studentDetails.getAddress());
        updateStudent.setGender(studentDetails.getGender());
        updateStudent.setCreated_at(studentDetails.getCreated_at());
        updateStudent.setUpdated_at(studentDetails.getUpdated_at());

        studentRepository.save(updateStudent);

        return ResponseEntity.ok(updateStudent);
    }

    // build delete student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id){

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));

        studentRepository.delete(student);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}