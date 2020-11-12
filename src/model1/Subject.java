/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.namespace.QName;

/**
 *
 * @author Brijesh
 */
@Entity
@Table(name = "Subjects")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "subject_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "subject")
    private Set<Test> tests = new HashSet<Test>();

    //---------Teacher annotation---------
    @OneToMany(mappedBy = "subject")
    private Set<Teacher> teachers = new HashSet<>();

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject(String name, Set<Test> tests, Set<Teacher> teachers) {
        this.name = name;
        this.tests = tests;
        this.teachers = teachers;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

   



    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name=" + name + ", students=" + ", tests=" + tests + '}';
    }
    
}
