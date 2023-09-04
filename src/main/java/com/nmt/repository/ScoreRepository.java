/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nmt.repository;

import com.nmt.model.Score;
import dto.StudentScoreDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author acer
 */
public interface ScoreRepository {
    List<Score> getScores(Map<String, String> params);
    int countScores();
    boolean addOrUpdateScore(Score u);
    Score getScoreById(int id);
    List<StudentScoreDTO> getScoreByStudentId(String studentId);
    List<StudentScoreDTO> getStudentScores(String lecturerId, String semesterId, String subjectId);
    List<StudentScoreDTO> getListScoresExport(String subjectId, String semesterId);
    boolean deleteScore(int id);
}
