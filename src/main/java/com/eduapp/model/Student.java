package com.eduapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private SchoolType schoolType;
    private Level level;
    private BigDecimal lessonCost;

    @ManyToMany
    @JoinTable(name = "students_lessons",
            joinColumns = {@JoinColumn(name = "students_id")},
            inverseJoinColumns = {@JoinColumn(name = "lessons_id")})
    private Set<Lesson> lessons;

    @ManyToMany
    @JoinTable(name = "students_tutors",
            joinColumns = {@JoinColumn(name = "students_id")},
            inverseJoinColumns = {@JoinColumn(name = "tutors_id")})
    private Set<Tutor> tutors;
}
