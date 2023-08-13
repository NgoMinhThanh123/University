/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nmt.service;
import com.nmt.model.Classes;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface ClassesService {
    List<Classes> getClasses(Map<String, String> params);
}
