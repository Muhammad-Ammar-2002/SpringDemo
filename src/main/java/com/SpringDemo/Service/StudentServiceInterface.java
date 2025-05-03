package com.SpringDemo.Service;

import com.SpringDemo.Model.CreateStudent;
import com.SpringDemo.Model.StudentDTO;

import java.util.List;

public interface StudentServiceInterface {

    StudentDTO saveStudent(CreateStudent student);
    
    void deleteStudent(Integer id);

    StudentDTO updateStudent(Integer id, StudentDTO student);


    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Integer id);
}
