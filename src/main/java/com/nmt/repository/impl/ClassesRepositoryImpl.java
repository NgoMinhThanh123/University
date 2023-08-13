/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.repository.impl;

import com.nmt.model.Classes;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nmt.repository.ClassesRepository;
import java.util.Map;

/**
 *
 * @author acer
 */
@Repository
@Transactional
public class ClassesRepositoryImpl implements ClassesRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Classes> getClasses(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Classes");
        
        return q.getResultList();
    }

}
