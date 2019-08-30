package com.codeabra.services.interfaces;

import com.codeabra.entities.Role;
import com.codeabra.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    List<Student> findAllByRole(Role role);

}
