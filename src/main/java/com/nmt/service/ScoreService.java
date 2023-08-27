/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nmt.service;

import com.nmt.model.Score;
import dto.StudentScoreDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author acer
 */
public interface ScoreService {
    List<Score> getScores(Map<String, String> params);
    int countScores();
    boolean addOrUpdateScore(Score u);
    Score getScoreById(int id);
    List<Score> getScoreByStudentId(String studentId);
    List<StudentScoreDTO> getStudentScores();
    boolean deleteScore(int id);
}
