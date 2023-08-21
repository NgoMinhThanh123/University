/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.service.impl;

import com.nmt.model.Student;
import com.nmt.repository.StudentRepository;
import com.nmt.service.StudentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepo;

    @Override
    public List<Student> getStudents(Map<String, String> params) {
        return this.studentRepo.getStudents(params);
    }

    @Override
    public boolean addStudent(Student c) {
        return this.studentRepo.addStudent(c);
    }

    @Override
    public boolean updateStudent(Student c) {
        return this.studentRepo.updateStudent(c);
    }

    @Override
    public Student getStudentById(String id) {
        return this.studentRepo.getStudentById(id);
    }

    @Override
    public boolean deleteStudent(String id) {
        return this.studentRepo.deleteStudent(id);
    }
    
}