package com.eduapp.model.DTOs;

import com.eduapp.model.Tutor;
import lombok.Getter;

@Getter
public class TutorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    public static TutorDTO fromTutor(Tutor tutor){
        TutorDTO tutorDTO = new TutorDTO();
        tutorDTO.id = tutor.getId();
        tutorDTO.firstName = tutor.getFirstName();
        tutorDTO.lastName = tutor.getLastName();
        return tutorDTO;
    }
}
