package com.example.dolphins.repo;

import com.example.dolphins.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Add custom queries if needed
}
