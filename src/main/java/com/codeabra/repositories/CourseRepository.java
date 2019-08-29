package com.codeabra.repositories;

import com.codeabra.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAllByDayOfWeek(int dayOfWeek);
}
