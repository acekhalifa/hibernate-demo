package com.crudhbn8.dao;

import com.crudhbn8.entities.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class InstructorDetailDAOImpl implements InstructorDetailDAO{

    private EntityManager entityManager;

    @Autowired
    public InstructorDetailDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(InstructorDetail instructorDetail) {
        entityManager.persist(instructorDetail);
    }

    @Override
    public InstructorDetail findById(int id) {

        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    public void deleteById(int id) {
        var instructorDetail = entityManager.find(InstructorDetail.class, id);
        entityManager.remove(instructorDetail);
    }
}
