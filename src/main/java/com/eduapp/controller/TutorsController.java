package com.eduapp.controller;

import com.eduapp.model.DTOs.TutorDTO;
import com.eduapp.model.Tutor;
import com.eduapp.service.TutorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class TutorsController {

    private final TutorsService tutorsService;

    @ResponseBody
    @GetMapping("tutors")
    public List<TutorDTO> getTutors(){
        return tutorsService.getTutors();
    }

    @ResponseBody
    @PostMapping("tutors")
    public Long saveTutor(@RequestBody Tutor tutor){
        return tutorsService.saveTutor(tutor);
    }
}
