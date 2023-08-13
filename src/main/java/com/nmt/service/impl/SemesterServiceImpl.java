/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.service.impl;

import com.nmt.model.Semester;
import com.nmt.repository.SemesterRepository;
import com.nmt.service.SemesterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class SemesterServiceImpl implements SemesterService{
    @Autowired
    private SemesterRepository semesterRepo;

    @Override
    public List<Semester> getSemesters() {
        return this.semesterRepo.getSemesters();
    }
    
}
