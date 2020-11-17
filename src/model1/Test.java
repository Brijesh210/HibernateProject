/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Brijesh
 */
@Entity
@Table(name = "Tests")
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    
    private Long id;

    @Column(updatable = false)
    private LocalDate date;
    
    @Column(updatable = false)
    private double grade;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "student_id", foreignKey = @javax.persistence.ForeignKey(name = "fk_test_stu"))
    private Student student;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "subject_id" ,foreignKey = @javax.persistence.ForeignKey(name = "fk_test_sub"))
    private Subject subject;

    public Test() {
    }

    public Test(LocalDate date, double grade) {
        this.date = date;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", date=" + date +
                ", grade=" + grade +
                '}';
    }
}
