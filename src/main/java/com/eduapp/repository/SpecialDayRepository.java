package com.eduapp.repository;

import com.eduapp.model.SpecialDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SpecialDayRepository extends JpaRepository<SpecialDay, Long> {
    List<SpecialDay> findSpecialDayByDateBetween(LocalDate startDate, LocalDate endDate);
}
