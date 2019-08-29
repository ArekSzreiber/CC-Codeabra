package com.codeabra.repositories;

import com.codeabra.entities.Gender;
import com.codeabra.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByGender(Gender gender);
}
