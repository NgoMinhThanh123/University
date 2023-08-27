/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nmt.service;

import com.nmt.model.Student;
import dto.StudentDto;
import java.util.List;
import java.util.Map;

/**
 *
 * @author acer
 */
public interface StudentService {
    List<Student> getStudents(Map<String, String> params);
    int countStudents();
    boolean addStudent(Student c);
    boolean updateStudent(Student c);
    Student getStudentById(String id);
    boolean deleteStudent(String id);
    StudentDto getStudentByUsername(String username);
    List<Student> getListStudentBySubjectAndLecturer(String lectureId, String subjectId);

}
