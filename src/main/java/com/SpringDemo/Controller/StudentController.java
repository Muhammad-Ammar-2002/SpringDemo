package com.SpringDemo.Controller;

import com.SpringDemo.Exceptions.CustomResponse;
import com.SpringDemo.Model.CreateStudent;
import com.SpringDemo.Model.StudentDTO;
import com.SpringDemo.Service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServiceInterface studentService;

    @PostMapping
    public ResponseEntity<CustomResponse> createStudent(@RequestBody CreateStudent student) {
        StudentDTO savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(new CustomResponse("201", "Student created successfully", savedStudent));
    }

    @GetMapping
    public ResponseEntity<CustomResponse> getAllStudents() {
        List<StudentDTO> students = studentService.getAllStudents();
        return ResponseEntity.ok(new CustomResponse("200", "Students retrieved successfully", students));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getStudentById(@PathVariable Integer id) {
        StudentDTO student = studentService.getStudentById(id);
        return ResponseEntity.ok(new CustomResponse("200", "Student retrieved successfully", student));
    }


    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO student) {
        StudentDTO updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(new CustomResponse("200", "Student updated successfully", updatedStudent));
    }


    // Delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
