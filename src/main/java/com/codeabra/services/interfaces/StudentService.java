package com.codeabra.services.interfaces;

import com.codeabra.entities.Gender;
import com.codeabra.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();

    void save(Student student);
    //todo merge to one method
    List<Student> findAllMales();//todo change to roles

    List<Student> findAllFemales();//todo change to roles

}
