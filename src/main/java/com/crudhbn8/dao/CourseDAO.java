package com.crudhbn8.dao;

import com.crudhbn8.entities.Course;

public interface CourseDAO {
    Course findByIdFetchJoin(int id);
    Course findById(int id);
    void deleteById(int id);
}
