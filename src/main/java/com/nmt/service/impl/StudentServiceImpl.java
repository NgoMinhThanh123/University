/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.service.impl;

import com.nmt.model.Student;
import com.nmt.repository.StudentRepository;
import com.nmt.service.StudentService;
import dto.StudentDto;
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

    @Override
    public StudentDto getStudentByUsername(String username) {
        Student u = this.studentRepo.getStudentByUsername(username);
        StudentDto studentDto = new StudentDto();
        studentDto.setId(u.getId());
        studentDto.setName(u.getName());
        studentDto.setBirthday(u.getBirthday());
        studentDto.setGender(u.getGender());
        studentDto.setPhone(u.getPhone());
        studentDto.setAddress(u.getAddress());
        studentDto.setClassesId(u.getClassesId());
        studentDto.setFacultyId(u.getFacultyId());
        studentDto.setMajorId(u.getMajorId());
        
        return studentDto;
    }

    @Override
    public List<Student> getListStudentBySubjectAndLecturer(String lectureId, String subjectId) {
        return this.studentRepo.getListStudentBySubjectAndLecturer(lectureId, subjectId);
    }

    @Override
    public int countStudents() {
        return this.studentRepo.countStudents();
    }
    
}
