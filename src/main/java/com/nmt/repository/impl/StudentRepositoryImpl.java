package com.nmt.repository.impl;

import com.nmt.model.Student;
import com.nmt.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nmt.repository.StudentRepository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.hibernate.HibernateException;

/**
 *
 * @author admin
 */
@Repository
@PropertySource("classpath:configs.properties")
@Transactional
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getStudents(Map<String, String> params) {

        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Student> q = b.createQuery(Student.class);
        Root root = q.from(Student.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
            }

            String mssv = params.get("mssv");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("id"), String.format("%%%s%%", mssv)));
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.desc(root.get("id")));

        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
            if (page != null) {
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
        }

        return query.getResultList();
    }

    @Override
    public boolean addStudent(Student c) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(c);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student c) {
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
    public Student getStudentById(String id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Student.class, id);
    }

    @Override
    public boolean deleteStudent(String id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Student t = this.getStudentById(id);
            s.delete(t);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Student getStudentByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            String hql = "FROM Student s WHERE s.userId.username = :username";
            Student student = s.createQuery(hql, Student.class)
                    .setParameter("username", username)
                    .uniqueResult();
            return student;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Student> getListStudentBySubjectAndLecturer(String lecturerId, String subjectId) {
        Session s = this.factory.getObject().getCurrentSession();
        List<Student> students = new ArrayList<>();

        try {
            String sql = "SELECT student.id, student.name, student.birthday, student.gender, student.phone, student.address, student.user_id, student.classes_id, student.faculty_id, student.major_id \n"
                    + "From student join student_subject on student.id = student_subject.student_id\n"
                    + "join subject on subject.id = student_subject.subject_id\n"
                    + "join lecturer_subject on subject.id = lecturer_subject.subject_id\n"
                    + "join lecturer on lecturer.id = lecturer_subject.lecturer_id "
                    + "WHERE subject.id = :subjectId AND lecturer.id = :lecturerId";

            Query query = s.createNativeQuery(sql);
            query.setParameter("subjectId", subjectId);
            query.setParameter("lecturerId", lecturerId);

            students = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public int countStudents() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM Student");

        return Integer.parseInt(q.getSingleResult().toString());
    }

}
