/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.controllers;

import com.nmt.model.Score;
import com.nmt.service.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */
@RestController
@RequestMapping("/api")
public class ApiScoreController {

    @Autowired
    private ScoreService scoreService;

    @DeleteMapping("/add_score/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.scoreService.deleteScore(id);
    }

    @GetMapping(path = "/score/studentId/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Score>> getScoresByStudentId(@RequestParam String studentId) {
        List<Score> list = scoreService.getScoreByStudentId(studentId);
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @GetMapping("/api/scores/export")
//    public void exportScores(HttpServletResponse response) throws IOException {
//        List<StudentScoreDTO> studentScores = scoreService.getStudentScores();
//
//        response.setContentType("text/csv");
//        response.setHeader("Content-Disposition", "attachment; filename=student_scores.csv");
//
//        CSVUtils.exportStudentScoresToCSV(studentScores, response.getWriter());
//    }
}
