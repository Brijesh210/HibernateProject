/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Brijesh
 */
@Entity
@PrimaryKeyJoinColumn(name="teacher_id", foreignKey = @javax.persistence.ForeignKey(name = "fk_tea_per"))
@Table(name = "Teachers")
public class Teacher extends Person implements Serializable {

    private String title;
    
    //------------Subject-----------
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="subject_id", foreignKey = @javax.persistence.ForeignKey(name = "fk_tea_sub"))
    private Subject subject;    


    public Teacher() {
    }

    public Teacher(String title) {
        this.title = title;
    }

    public Teacher(String fName, String sName, String email) {
        super(fName, sName, email);
    }
    
    public Teacher(String title, Person person) {
        super();
        this.title = title;
    }

    public Teacher(String title, Subject subject, String fName, String sName, String email) {
        super(fName, sName, email);
        this.title = title;
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "title='" + title + '\'' +
                ", subject=" + subject +
                '}';
    }
}
