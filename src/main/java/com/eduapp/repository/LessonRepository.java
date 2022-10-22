package com.eduapp.repository;

import com.eduapp.model.Lesson;
import com.eduapp.model.Student;
import com.eduapp.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByTutor(Tutor tutor);
    List<Lesson> findByStudentsContains(Student student);
}
