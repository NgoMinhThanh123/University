/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dto.StudentScoreDTO;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author acer
 */
public class CSVUtils {
    public static void exportStudentScoresToCSV(List<StudentScoreDTO> studentScores, PrintWriter writer) {
        writer.println("Student Name,Quá trình,Giữa kì,Cuối kì");

        for (StudentScoreDTO studentScore : studentScores) {
            writer.println(
                studentScore.getSubjectName()+ "," +
                studentScore.getSemesterName()+ "," +
                studentScore.getSchoolYear()+ "," +
                studentScore.getScoreColumnName()+ "," +
                studentScore.getScoreValue()
            );
        }
    }
}
