package com.codeabra.services.interfaces;

import com.codeabra.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();

}
