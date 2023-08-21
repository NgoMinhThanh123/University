/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nmt.model.User;
import com.nmt.repository.UserRepository;
import com.nmt.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author acer
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public List<User> getUsers(Map<String, String> params) {
        return this.userRepo.getUsers(params);
    }

    @Override
    public boolean addOrUpdateUser(User u) {

        if (!u.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(u.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                u.setAvatar(res.get("secure_url").toString());
                u.setPassword(encoder.encode(u.getPassword()));

            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.userRepo.addOrUpdateUser(u);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepo.getUserById(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return this.userRepo.deleteUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.userRepo.getUserByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid user!");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getRole()));

        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.userRepo.authUser(username, password);
    }

    @Override
    public User getUserByUn(String username) {
        return this.userRepo.getUserByUsername(username);
    }

    @Override
    public User addUser(Map<String, String> params, MultipartFile avatar) {
        User u = new User();
        u.setEmail(params.get("email"));
        u.setUsername(params.get("username"));
        u.setPassword(this.encoder.encode(params.get("password")));
        u.setRole("ROLE_SINHVIEN");
        if (!avatar.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(), 
                        ObjectUtils.asMap("resource_type", "auto"));
                u.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.userRepo.addUser(u);
        return u;
    }

}
