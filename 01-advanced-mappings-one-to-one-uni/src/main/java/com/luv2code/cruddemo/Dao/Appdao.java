package com.luv2code.cruddemo.Dao;

import com.luv2code.cruddemo.entity.Instructor;

public interface Appdao {
    void save (Instructor theinstructor);
    Instructor findInstuctorById (int theid);
    void removeById (int theid);
}

