package com.example.dolphins.service;

import com.example.dolphins.model.Student;
import java.util.List;

public interface StudentService {
    Student save(Student student);
    List<Student> findAll();
    Student findById(Long id);
    void delete(Long id);
}
