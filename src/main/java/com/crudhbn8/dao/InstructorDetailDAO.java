package com.crudhbn8.dao;

import com.crudhbn8.entities.InstructorDetail;
public interface InstructorDetailDAO {
    void save(InstructorDetail instructorDetail);
    InstructorDetail findById(int id);
    void deleteById(int id);
}
