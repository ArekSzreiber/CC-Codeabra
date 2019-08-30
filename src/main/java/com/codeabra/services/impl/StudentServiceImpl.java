package com.codeabra.services.impl;

import com.codeabra.entities.Role;
import com.codeabra.entities.Student;
import com.codeabra.repositories.StudentRepository;
import com.codeabra.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "StudentServiceImpl")
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAllByRole(Role role) {
        return studentRepository.findAllByRole(role);
    }



}
