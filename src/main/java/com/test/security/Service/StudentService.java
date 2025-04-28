package com.test.security.Service;

import com.test.security.Mapper.StudentMapper;
import com.test.security.Model.CreateStudent;
import com.test.security.Model.StudentDTO;
import com.test.security.Entity.Student;
import com.test.security.Repository.StudentRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.test.security.Mapper.StudentMapper.mapToDTO;
import static com.test.security.Mapper.StudentMapper.mapToEntity;


@Service
@RequiredArgsConstructor
public class StudentService implements StudentServiceInterface {

    private final StudentRepo    repo;

    @Override
    public StudentDTO saveStudent(CreateStudent student) {
        Student studentEntity = mapToEntity(student);
        Student savedStudent = repo.save(studentEntity);
        return mapToDTO(savedStudent);
    }

    @Override
    public void deleteStudent(Integer id) {
        repo.deleteById(id);

    }

    @Override
    public StudentDTO updateStudent(Integer id, StudentDTO student) {

        Student studentInDb = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentInDb.setName(student.getName());
        studentInDb.setMarks(student.getMark());
        Student updatedStudent = repo.save(studentInDb);
        return mapToDTO(updatedStudent);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = repo.findAll();
        return students.stream()
                .map(StudentMapper::mapToDTO)
                .toList();
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return mapToDTO(student);
    }



}
