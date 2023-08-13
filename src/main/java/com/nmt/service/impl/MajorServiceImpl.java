/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.service.impl;

import com.nmt.model.Major;
import com.nmt.repository.MajorRepository;
import com.nmt.service.MajorService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class MajorServiceImpl implements MajorService{
    @Autowired
    private MajorRepository majorRepo;

    @Override
    public List<Major> getMajors(Map<String, String> params) {
        return this.majorRepo.getMajors(params);
    }


    @Override
    public Major getMajorById(String id) {
        return this.majorRepo.getMajorById(id);
    }

    @Override
    public boolean addMajor(Major m) {
        if(m != null)
            return this.majorRepo.addMajor(m);
        else
            throw new RuntimeException("Update thất bại!");   
    }

    @Override
    public boolean updateMajor(Major m) {
        if(m != null)
            return this.majorRepo.updateMajor(m);
        else
            throw new RuntimeException("Update thất bại!");        
    }
 
}
