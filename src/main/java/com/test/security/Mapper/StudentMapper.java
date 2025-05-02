package com.test.security.Mapper;

import com.test.security.Entity.Student;
import com.test.security.Model.CreateStudent;
import com.test.security.Model.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public static Student mapToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setRollNo(studentDTO.getRollNo());
        student.setName(studentDTO.getName());
        student.setMarks(studentDTO.getMark());
        return student;
    }

    public static StudentDTO mapToDTO(Student student) {
        return new StudentDTO(student.getRollNo(), student.getName(), student.getMarks());
    }

    public static Student mapToEntity(CreateStudent createStudent) {
        Student student = new Student();
        student.setName(createStudent.getName());
        student.setMarks(createStudent.getMark());
        return student;
    }
}
