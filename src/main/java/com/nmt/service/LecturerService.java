/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nmt.service;

import com.nmt.model.Lecturer;
import java.util.List;
import java.util.Map;

/**
 *
 * @author acer
 */
public interface LecturerService {
    List<Lecturer> getLecturers(Map<String, String> params);
    int countLecturers();
}
