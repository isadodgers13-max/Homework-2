package com.example.dolphins.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "classes")
public class SwimClass {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Class name required")
    private String name;

    private String level; // e.g., Beginner, Intermediate

    private String dayOfWeek; // e.g., Monday, Tuesday (or use enum)
    private String time; // or LocalTime if you prefer

    @ManyToMany
    @JoinTable(
        name = "enrollments",
        joinColumns = @JoinColumn(name = "class_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students = new HashSet<>();

    // constructors, getters, setters ...
}
