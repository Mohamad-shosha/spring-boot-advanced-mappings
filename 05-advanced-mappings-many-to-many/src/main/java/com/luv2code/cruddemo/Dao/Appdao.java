package com.luv2code.cruddemo.Dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface Appdao {
    //#
    void save (Instructor theinstructor);
    Instructor findInstuctorById (int theid);
    void removeById (int theid);
    InstructorDetail findInsttructorById(int id);
    void removeInstructorDetail (int id);
    //#
    List<Course> FindCoursesByInstructorId(int id);
    Instructor FindInstructorByIdJoinFetch(int id);
    void Update (Instructor instructor);
    Course findCourseById (int id);
    void updateCourse(Course course);
    void deleteCourseById(int id);
    //#
    void saveCourse(Course course);
    Course findCourseAndReviewByCourseId (int id);
}

