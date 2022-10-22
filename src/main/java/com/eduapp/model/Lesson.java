package com.eduapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private LocalTime time;
    private int duration;
    private String topic;
    private String notes;
    private String homework;
    private LessonStatus status;
    @ManyToMany(mappedBy = "lessons")
    private Set<Student> students;

    @ManyToOne
    private Tutor tutor;
}
