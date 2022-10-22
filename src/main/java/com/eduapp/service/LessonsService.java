package com.eduapp.service;

import com.eduapp.model.DTOs.LessonDTO;
import com.eduapp.model.Lesson;
import com.eduapp.model.SpecialDay;
import com.eduapp.model.Student;
import com.eduapp.model.Tutor;
import com.eduapp.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonsService {

    private final LessonRepository lessonRepository;
    private final StudentsService studentsService;
    private final TutorsService tutorsService;
    private final SpecialDayService specialDayService;

    public Long saveLesson(Lesson lesson){
        return lessonRepository.save(lesson).getId();
    }

//    public void saveLessonSeries(Lesson firstLesson, LocalDate endDate){
//        lessonRepository.save(firstLesson);
//        List<SpecialDay> specialDays = specialDayService.getSpecialDayByDateBetween(firstLesson.getDate(), endDate);
//        LocalDate date = firstLesson.getDate().plus(7, ChronoUnit.DAYS);
//        while (date.isBefore(endDate)){
//            if(specialDays.stream().anyMatch(specialDay -> specialDay.getDate().equals(date))){
//                continue;
//            }
//            Lesson lesson = new Lesson();
//            lesson.setDate(date);
//            lesson.setDuration(firstLesson.getDuration());
//            lesson.setTime(firstLesson.getTime());
//            lesson.setStudents(firstLesson.getStudents());
//            lesson.setTutor(firstLesson.getTutor());
//            lessonRepository.save(lesson);
//            date = date.plus(7, ChronoUnit.DAYS);
//        }
//    }

    public List<LessonDTO> getLessonsByStudentId(Long id){
        Optional<Student> student = studentsService.getStudentById(id);
        if(student.isPresent()){
            return getLessonsByStudent(student.get());
        }
        throw new NoSuchElementException("There is no student with id: " + id);
    }

    public List<LessonDTO> getLessonsByStudent(Student student){
        return lessonRepository
                .findByStudentsContains(student)
                .stream()
                .map(LessonDTO::fromLesson)
                .collect(Collectors.toList());
    }

    public List<LessonDTO> getLessonsFromTutor(Tutor tutor){
        return lessonRepository
                .findByTutor(tutor)
                .stream()
                .map(LessonDTO::fromLesson)
                .collect(Collectors.toList());
    }

    public List<LessonDTO> getLessonsByTutorId(Long id) {
        Optional<Tutor> tutor = tutorsService.getTutorById(id);
        if(tutor.isPresent()){
            return getLessonsFromTutor(tutor.get());
        }
        throw new NoSuchElementException("There is no tutor with id: " + id);
    }
}
