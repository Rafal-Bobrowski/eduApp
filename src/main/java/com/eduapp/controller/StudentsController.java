package com.eduapp.controller;

import com.eduapp.model.DTOs.StudentDTO;
import com.eduapp.model.Student;
import com.eduapp.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;

    @ResponseBody
    @GetMapping
    public List<StudentDTO> getStudents(){
        return studentsService.getStudents();
    }

    @ResponseBody
    @PostMapping
    public Long saveStudent(@RequestBody Student student){
        return studentsService.saveStudent(student);
    }
}
