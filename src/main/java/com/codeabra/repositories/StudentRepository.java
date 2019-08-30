package com.codeabra.repositories;

import com.codeabra.entities.Role;
import com.codeabra.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByRole(Role role);
}
