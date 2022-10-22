package com.eduapp.service;

import com.eduapp.model.DTOs.StudentDTO;
import com.eduapp.model.Student;
import com.eduapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentRepository studentRepository;

    public List<StudentDTO> getStudents(){
        return studentRepository
                .findAll()
                .stream()
                .map(StudentDTO::fromStudent)
                .collect(Collectors.toList());
    }

    public Long saveStudent(Student student){
        return studentRepository.save(student).getId();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
}
