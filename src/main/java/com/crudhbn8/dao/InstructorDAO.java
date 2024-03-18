package com.crudhbn8.dao;

import com.crudhbn8.entities.Course;
import com.crudhbn8.entities.Instructor;

import java.util.List;

public interface InstructorDAO {
    List<Course> findCoursesByInstructorId(int id);
    void save(Instructor instructor);
    Instructor findById(int id);
    Instructor findByIdJoinFetch(int id);
    void update(Instructor instructor);
    void deleteById(int id);

}
