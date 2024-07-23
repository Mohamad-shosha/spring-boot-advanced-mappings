package com.luv2code.cruddemo.Dao;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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


}
