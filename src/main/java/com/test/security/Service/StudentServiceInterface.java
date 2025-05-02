package com.test.security.Service;

import com.test.security.Model.CreateStudent;
import com.test.security.Model.StudentDTO;

import java.util.List;

public interface StudentServiceInterface {

    StudentDTO saveStudent(CreateStudent student);

    void deleteStudent(Integer id);

    StudentDTO updateStudent(Integer id, StudentDTO student);


    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Integer id);
}
