/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nmt.service;

import com.nmt.model.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author acer
 */
public interface UserService extends UserDetailsService{
    List<User> getUsers(Map<String, String> params);
    boolean addOrUpdateUser(User u);
    User getUserById(int id);
    boolean deleteUser(int id);
}
