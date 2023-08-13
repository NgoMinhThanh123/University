package com.nmt.repository.impl;

import com.nmt.model.Semester;
import com.nmt.repository.SemesterRepository;
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
public class SemesterRepositoryImpl implements SemesterRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Semester> getSemesters() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Semester");
        
        return q.getResultList();
    }
    
}
