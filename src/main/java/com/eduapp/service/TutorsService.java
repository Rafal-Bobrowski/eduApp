package com.eduapp.service;

import com.eduapp.model.DTOs.TutorDTO;
import com.eduapp.model.Tutor;
import com.eduapp.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutorsService {

    private final TutorRepository tutorRepository;

    public Long saveTutor(Tutor tutor){
        return tutorRepository.save(tutor).getId();
    }
    public List<TutorDTO> getTutors(){
        return tutorRepository
                .findAll()
                .stream()
                .map(TutorDTO::fromTutor)
                .collect(Collectors.toList());
    }

    public Optional<Tutor> getTutorById(Long id) {
        return tutorRepository.findById(id);
    }
}
