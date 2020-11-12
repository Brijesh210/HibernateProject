/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Brijesh
 */
@Entity
@PrimaryKeyJoinColumn(name="student_id",foreignKey = @javax.persistence.ForeignKey(name = "fk_stu_per"))
@Table(name="Students")
public class Student extends Person implements Serializable {
    
    @Column(length = 5)
    private int semester;
    
    @Column(length = 7)
    private String indexNo;
    
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="field_of_study_id", foreignKey = @javax.persistence.ForeignKey(name = "fk_fos_stu"))
    private FieldOfStudy fieldOfStudys;
    
    @OneToMany(mappedBy = "student")
    private Set<Test> tests = new HashSet<Test>();
    
    public Student() {
    }

    public Student(String fName, String sName, String email) {
        super(fName, sName, email);
    }

    public Student(FieldOfStudy fieldOfStudys, String indexNo, int semester, String fName, String sName, String email) {
        super(fName, sName, email);
        this.fieldOfStudys = fieldOfStudys;
        this.indexNo = indexNo;
        this.semester = semester;
    }
    
    public Student(FieldOfStudy fieldOfStudys, int semester) {
        this.fieldOfStudys = fieldOfStudys;
        this.semester = semester;
    }
    

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public FieldOfStudy getFieldOfStudys() {
        return fieldOfStudys;
    }

    public void setFieldOfStudys(FieldOfStudy fieldOfStudys) {
        this.fieldOfStudys = fieldOfStudys;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    

}
