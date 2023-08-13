/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.service.impl;

import com.nmt.model.Staff;
import com.nmt.repository.StaffRepository;
import com.nmt.service.StaffService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepo;

    @Override
    public List<Staff> getStaffs(Map<String, String> params) {
        return this.staffRepo.getStaffs(params);
    }
    
}
