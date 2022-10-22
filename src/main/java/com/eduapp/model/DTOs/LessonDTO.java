package com.eduapp.model.DTOs;

import com.eduapp.model.Lesson;
import com.eduapp.model.LessonStatus;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class LessonDTO {
    private Long id;

    private LocalTime time;
    private LocalDate date;
    private int duration;
    private String topic;
    private String notes;
    private String homework;
    private LessonStatus status;

    public static LessonDTO fromLesson(Lesson lesson){
        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.id = lesson.getId();
        lessonDTO.time = lesson.getTime();
        lessonDTO.date = lesson.getDate();
        lessonDTO.duration = lesson.getDuration();
        lessonDTO.topic = lesson.getTopic();
        lessonDTO.notes = lesson.getNotes();
        lessonDTO.homework = lesson.getHomework();
        lessonDTO.status = lesson.getStatus();

        return lessonDTO;
    }
}
