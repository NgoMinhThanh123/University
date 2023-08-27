/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.repository.impl;

import com.nmt.model.Score;
import com.nmt.repository.ScoreRepository;
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
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author acer
 */
@Repository
@Transactional
public class ScoreRepositoryImpl implements ScoreRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Score> getScores(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Score> q = b.createQuery(Score.class);
        Root root = q.from(Score.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("id"), String.format("%%%s%%", kw)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.asc(root.get("id")));

        Query query = s.createQuery(q);
        if (params != null) {
            String page = params.get("page");
            if (page != null) {
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
        }

        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateScore(Score u) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (u.getId() == null) {
                s.save(u);
            } else {
                s.update(u);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Score getScoreById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Score.class, id);
    }

    @Override
    public boolean deleteScore(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Score t = this.getScoreById(id);
            s.delete(t);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int countScores() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM Score");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<Score> getScoreByStudentId(String studentId) {
        Session s = this.factory.getObject().getCurrentSession();
        List<Score> scores = new ArrayList<>();
        try {
            String sql = "SELECT student.name AS student_name, semester.name AS semester_name, semester.school_year, subject.name AS subject_name, score_value.value, score_column.name AS score_column_name\n"
                    + "FROM score join subject on score.subject_id = subject.id\n"
                    + "join semester on score.semester_id = semester.id\n"
                    + "join student on score.student_id = student.id\n"
                    + "join score_value on score_value.score_id = score.id\n"
                    + "join score_column on score_value.score_column_id = score_column.id\n"
                    + "where student.id = :studentId";
            Query query = s.createNativeQuery(sql);
            query.setParameter("studentId", studentId);

            scores = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scores;
    }

    @Override
    public List<Score> getStudentScores() {
        Session s = this.factory.getObject().getCurrentSession();
        List<Score> scores = new ArrayList<>();
        try {
            String sql = "SELECT student.name AS student_name, semester.name AS semester_name, semester.school_year, subject.name AS subject_name, score_value.value, score_column.name AS score_column_name\n"
                    + "FROM score join subject on score.subject_id = subject.id\n"
                    + "join semester on score.semester_id = semester.id\n"
                    + "join student on score.student_id = student.id\n"
                    + "join score_value on score_value.score_id = score.id\n"
                    + "join score_column on score_value.score_column_id = score_column.id";
            Query query = s.createNativeQuery(sql);

            scores = query.getResultList();
            System.out.println(scores);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scores;
    }

}
