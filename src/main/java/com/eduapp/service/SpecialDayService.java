package com.eduapp.service;

import com.eduapp.model.SpecialDay;
import com.eduapp.repository.SpecialDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialDayService {
    private final SpecialDayRepository specialDayRepository;

    public Long saveSpecialDay(SpecialDay specialDay){
        return specialDayRepository.save(specialDay).getId();
    }

    public List<SpecialDay> getSpecialDayByDateBetween(LocalDate startDate, LocalDate endDate){
        return specialDayRepository.findSpecialDayByDateBetween(startDate, endDate);
    }
}
