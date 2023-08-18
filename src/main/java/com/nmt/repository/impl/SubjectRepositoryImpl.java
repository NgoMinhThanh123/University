package com.nmt.repository.impl;

import com.nmt.model.Subject;
import com.nmt.repository.SubjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class SubjectRepositoryImpl implements SubjectRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Subject> getSubjects(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Subject> q = b.createQuery(Subject.class);
        Root root = q.from(Subject.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.asc(root.get("id")));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addSubject(Subject c) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(c);

        return true;
    }

    @Override
    public boolean updateSubject(Subject c) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.update(c);

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Subject getSubjectById(String id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Subject.class, id);
    }

    @Override
    public boolean deleteSubject(String id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Subject t = this.getSubjectById(id);
            s.delete(t);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
