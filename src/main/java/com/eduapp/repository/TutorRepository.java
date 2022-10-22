package com.eduapp.repository;

import com.eduapp.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
