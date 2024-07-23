package com.luv2code.cruddemo.Dao;
import com.luv2code.cruddemo.entity.Instructor;
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
}
