/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.repository.impl;

import com.nmt.model.ScoreValue;
import com.nmt.repository.ScoreValueRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author acer
 */
@Repository
@Transactional
public class ScoreValueRepositoryImpl implements ScoreValueRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<ScoreValue> getScoreValues() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM ScoreValue");
        
        return q.getResultList();
    }
    
}
