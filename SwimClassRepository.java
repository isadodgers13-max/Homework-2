package com.example.dolphins.repo;

import com.example.dolphins.model.SwimClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SwimClassRepository extends JpaRepository<SwimClass, Long> {
    // findByDayOfWeek, findByLevel etc. if needed
}
