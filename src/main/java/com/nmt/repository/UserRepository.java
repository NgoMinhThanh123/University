/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nmt.repository;

import com.nmt.model.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author acer
 */
public interface UserRepository {
    List<User> getUsers(Map<String, String> params);
    boolean addOrUpdateUser(User u);
    User getUserById(int id);
}
