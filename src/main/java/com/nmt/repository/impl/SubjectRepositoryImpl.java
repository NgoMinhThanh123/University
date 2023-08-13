package com.nmt.repository.impl;

import com.nmt.model.Subject;
import com.nmt.repository.SubjectRepository;
import java.util.List;
import java.util.Map;
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
public class SubjectRepositoryImpl implements SubjectRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Subject> getSubjects(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Subject");
        
        return q.getResultList();
    }
    
}
