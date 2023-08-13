/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.service.impl;

import com.nmt.model.Lecturer;
import com.nmt.repository.LecturerRepository;
import com.nmt.service.LecturerService;;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author acer
 */
@Service
public class LectureServiceImpl implements LecturerService{
    @Autowired
    private LecturerRepository lecturersRepo;

    @Override
    public List<Lecturer> getLecturers(Map<String, String> params) {
        return this.lecturersRepo.getLecturers(params);
    }

    @Override
    public int countLecturers() {
        return this.lecturersRepo.countLecturers();
    }
    
}
