package com.crudhbn8.dao;


import com.crudhbn8.entities.Course;
import com.crudhbn8.entities.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InstructorDAOImpl implements InstructorDAO {
    private EntityManager entityManager;

    @Autowired
    public InstructorDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public Instructor findByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "FROM Instructor i JOIN FETCH i.courses where i.id = :data", Instructor.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public void deleteById(int id) {
        var instructor = entityManager.find(Instructor.class, id);
        var courses = instructor.getCourses();
        for(var course : courses){
            course.setInstructor(null);
        }
        entityManager.remove(instructor);
    }
}
