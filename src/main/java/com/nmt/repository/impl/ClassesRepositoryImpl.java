/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.repository.impl;

import com.nmt.model.Classes;
import com.nmt.repository.ClassesRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.HibernateException;
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
public class ClassesRepositoryImpl implements ClassesRepository{
     @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Classes> getClasses(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Classes");

        return q.getResultList();
    }

    @Override
    public boolean addClass(Classes c) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (c.getId() == null) {
                s.save(c);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateClass(Classes c) {
          Session s = this.factory.getObject().getCurrentSession();
        try {
            if (c.getId() != null) {
                s.save(c);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Classes getClassById(String id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Classes.class, id);
    }

    @Override
    public boolean deleteClass(String id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Classes c = this.getClassById(id);
            s.delete(c);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
