/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nmt.repository;

import com.nmt.model.Student;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface StudentRepository {
    List<Student> getStudents(Map<String, String> params);
    int countStudents();
    boolean addStudent(Student c);
    boolean updateStudent(Student c);
    Student getStudentById(String id);
    Student getStudentByUsername(String username);
    boolean deleteStudent(String id);
    List<Student> getListStudentBySubjectAndLecturer(String lecturerId, String subjectId);
}
