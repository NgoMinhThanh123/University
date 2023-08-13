/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.controllers;

import com.nmt.model.Faculty;
import com.nmt.service.FacultyService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author acer
 */
@Controller
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    
    @GetMapping("/faculty")
    public String list(Model model, @RequestParam Map<String, String> params) {
        List<Faculty> facultys = this.facultyService.getFaculties(params);
        model.addAttribute("faculty", this.facultyService.getFaculties(params));
        
        return "faculty";
    }
    
    @GetMapping("/add_faculty")
    public String addList(Model model){
        model.addAttribute("add_faculty", new Faculty());
        
        return "add_faculty";
    }
    
}
