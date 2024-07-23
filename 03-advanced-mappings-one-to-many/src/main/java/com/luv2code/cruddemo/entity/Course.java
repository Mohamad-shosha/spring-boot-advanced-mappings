package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;
    @Column(name = "title")
    private String title;
    @ManyToOne(cascade = {CascadeType.REFRESH , CascadeType.PERSIST ,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE})
    @JoinColumn(name = "instructor_id")
    Instructor Instructorid;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructorid() {
        return Instructorid;
    }

    public void setInstructorid(Instructor instructorid) {
        Instructorid = instructorid;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Instructorid=" + Instructorid +
                '}';
    }
}
