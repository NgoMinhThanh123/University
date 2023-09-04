/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.service.impl;

import com.nmt.model.Score;
import com.nmt.repository.ScoreRepository;
import com.nmt.service.ScoreService;
import dto.StudentScoreDTO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreRepository scoreRepo;

    @Override
    public List<Score> getScores(Map<String, String> params) {
        return this.scoreRepo.getScores(params);
    }

    @Override
    public boolean addOrUpdateScore(Score u) {
        return this.scoreRepo.addOrUpdateScore(u);
    }

    @Override
    public Score getScoreById(int id) {
        return this.scoreRepo.getScoreById(id);
    }

    @Override
    public boolean deleteScore(int id) {
        return this.scoreRepo.deleteScore(id);
    }

    @Override
    public int countScores() {
        return this.scoreRepo.countScores();
    }

    @Override
    public List<StudentScoreDTO> getStudentScores(String lecturerId, String semesterId, String subjectId) {
        return this.scoreRepo.getStudentScores(lecturerId, semesterId, subjectId);
    }

    @Override
    public List<StudentScoreDTO> getListScoresExport(String subjectId, String semesterId) {
        return this.scoreRepo.getListScoresExport(semesterId, subjectId);
    }

    @Override
    public List<StudentScoreDTO> getScoreByStudentId(String studentId) {
        return this.scoreRepo.getScoreByStudentId(studentId);
    }
    
}
