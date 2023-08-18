/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nmt.repository;

import com.nmt.model.Semester;
import java.util.List;
import java.util.Map;

/**
 *
 * @author acer
 */
public interface SemesterRepository {
    List<Semester> getSemesters(Map<String, String> params);
    boolean addSemester(Semester m);
    boolean updateSemester(Semester m);
    Semester getSemesterById(String id);
    boolean deleteSemester(String id);
}
