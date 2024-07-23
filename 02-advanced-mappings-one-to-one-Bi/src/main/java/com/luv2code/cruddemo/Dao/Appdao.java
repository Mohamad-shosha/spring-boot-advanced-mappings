package com.luv2code.cruddemo.Dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface Appdao {
    void save (Instructor theinstructor);
    Instructor findInstuctorById (int theid);
    void removeById (int theid);
    InstructorDetail findInsttructorById(int id);
    void removeInstructorDetail (int id);
}

