/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.service.impl;

import com.nmt.model.ScoreValue;
import com.nmt.repository.ScoreValueRepository;
import com.nmt.service.ScoreValueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class ScoreValueServiceImpl implements ScoreValueService{
    @Autowired
    private ScoreValueRepository scoreValueRepo;

    @Override
    public List<ScoreValue> getScoreValues() {
        return this.scoreValueRepo.getScoreValues();
    }
    
}
