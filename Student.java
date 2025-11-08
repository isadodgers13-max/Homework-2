package com.example.dolphins.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name required")
    private String firstName;

    @NotBlank(message = "Last name required")
    private String lastName;

    @Email
    private String email;

    // Bi-directional many-to-many:
    @ManyToMany(mappedBy = "students")
    private Set<SwimClass> classes = new HashSet<>();

    // constructors, getters, setters ...
}
