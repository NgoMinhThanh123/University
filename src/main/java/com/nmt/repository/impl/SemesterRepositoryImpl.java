package com.nmt.repository.impl;

import com.nmt.model.Semester;
import com.nmt.repository.SemesterRepository;
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
public class SemesterRepositoryImpl implements SemesterRepository{
    @Autowired
    private LocalSessionFactoryBean factory;


    @Override
    public List<Semester> getSemesters(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Semester> q = b.createQuery(Semester.class);
        Root root = q.from(Semester.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("schoolYear"), String.format("%%%s%%", kw)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.desc(root.get("id")));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public Semester getSemesterById(String id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Semester.class, id);
    }

    @Override
    public boolean deleteSemester(String id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Semester m = this.getSemesterById(id);
            s.delete(m);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addSemester(Semester m) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(m);

        return true;
    }

    @Override
    public boolean updateSemester(Semester m) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if(m.getId() != null)
                s.update(m);

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
