package com.crudhbn8.dao;

import com.crudhbn8.entities.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    void delete(int id);
}
