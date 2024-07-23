package com.luv2code.cruddemo.Dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppdaoImp implements Appdao{
    private EntityManager entityManager;
    @Autowired
    public AppdaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theinstructor) {
        entityManager.persist(theinstructor);
    }

    @Override
    public Instructor findInstuctorById(int theid) {
        Instructor theInstructor = entityManager.find(Instructor.class,theid);
        return theInstructor;
    }

    @Override
    @Transactional
    public void removeById(int theid) {
        Instructor theInstructor = entityManager.find(Instructor.class,theid);
        List<Course> courses = theInstructor.getCourses();
        for(Course course : courses){
            course.setInstructorid(null);
        }
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInsttructorById(int id) {
        InstructorDetail theInstructorDetail = entityManager.find(InstructorDetail.class,id);
        return theInstructorDetail ;
    }
    @Transactional
    @Override
    public void removeInstructorDetail(int id) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class,id);
        //#
        tempInstructorDetail.getInstructor().setInstructorDetailId(null);
        //#
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> FindCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where Instructorid.id = :data", Course.class);
        query.setParameter("data",id);
        List<Course> list = query.getResultList();
        return list;
    }

    //JPQL "Java Persistence Query Language."
    @Override
    public Instructor FindInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "+
                                                                "JOIN FETCH i.courses "+
                                                                "JOIN FETCH i.instructorDetailId "+
                                                                "where i.id = :data", Instructor.class);
        query.setParameter("data",id);
        Instructor instructor = query.getSingleResult();
        return instructor ;
    }

    @Override
    @Transactional
    public void Update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class,id);
    }
    @Transactional
    @Override
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Transactional
    @Override
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

    @Transactional
    @Override
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery( "select c from Course c "+
                                                                  "JOIN FETCH c.reviews "+
                                                                  "where c.id = :data ", Course.class);
        query.setParameter("data",id);
        Course course =  query.getSingleResult();
        return course;
    }

    @Override
    public Course findCourseAndStudentByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c "+
                                                                "JOIN FETCH c.students " +
                                                                "where c.id = : data ",Course.class);
        query.setParameter("data",id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentAndCourseByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s "+
                "JOIN FETCH s.courses " +
                "where s.id = : data ",Student.class);
        query.setParameter("data",id);
        Student student = query.getSingleResult();
        return student;
    }

    @Transactional
    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }
    @Transactional
    @Override
    public void deleteStudentByStudentId(int id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }


}
