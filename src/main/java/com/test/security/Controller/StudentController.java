package com.test.security.Controller;

import com.test.security.Model.CreateStudent;
import com.test.security.Model.StudentDTO;
import com.test.security.Service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServiceInterface studentService;

    // Create a new student
    @PostMapping
    public StudentDTO createStudent(@RequestBody CreateStudent student) {
        return studentService.saveStudent(student);
    }

    // Get all students
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    // Update a student
    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Integer id, @RequestBody StudentDTO student) {
        return studentService.updateStudent(id, student);
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}

