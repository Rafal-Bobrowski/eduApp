package com.eduapp.controller;

import com.eduapp.model.DTOs.LessonDTO;
import com.eduapp.model.Lesson;
import com.eduapp.service.LessonsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LessonController {

    private final LessonsService lessonsService;

    @GetMapping("student/lessons")
    @ResponseBody
    public List<LessonDTO> getLessonsByStudentId(@RequestParam(name = "student_id") Long id){
        return lessonsService.getLessonsByStudentId(id);
    }

    @GetMapping("tutor/lessons")
    @ResponseBody
    public List<LessonDTO> getLessonsByTutorId(@RequestParam(name = "tutor_id") Long id){
        return lessonsService.getLessonsByTutorId(id);
    }

    @PostMapping("tutor/lessons")
    @ResponseBody
    public Long createLesson(@RequestBody Lesson lesson){
        return lessonsService.saveLesson(lesson);
    }

    @PostMapping("student/lessons")
    @ResponseBody
    public Long askForLesson(@RequestBody Lesson lesson){
        return lessonsService.saveLesson(lesson);
    }
}
