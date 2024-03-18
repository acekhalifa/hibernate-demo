package com.crudhbn8.dao;

import com.crudhbn8.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CourseDAOImpl implements CourseDAO{
    private EntityManager entityManager;

    @Autowired
    public CourseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Course findByIdFetchJoin(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Courses c JOIN FETCH c.reviews WHERE c.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        var course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
