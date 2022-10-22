package com.eduapp.model.DTOs;

import com.eduapp.model.Level;
import com.eduapp.model.SchoolType;
import com.eduapp.model.Student;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private SchoolType schoolType;
    private Level level;
    private BigDecimal lessonCost;

    public static StudentDTO fromStudent(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.id = student.getId();
        studentDTO.firstName = student.getFirstName();
        studentDTO.lastName = student.getLastName();
        studentDTO.schoolType = student.getSchoolType();
        studentDTO.level = student.getLevel();
        studentDTO.lessonCost = student.getLessonCost();

        return studentDTO;
    }
}
