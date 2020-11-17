/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Brijesh
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "Persons")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "person_id")
    private Long id;
    
    private String fName;
    
    private String sName;

    private String email;
    
    @OneToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name="ADDRESS_ID", foreignKey = @javax.persistence.ForeignKey(name="FK_PERSON_ADDRESS"))
    private Address address;

    public Person() {
    }

    public Person(String fName, String sName, String email) {
        this.fName = fName;
        this.sName = sName;
        this.email = email;
    }

    public Person(String fName, String sName, String email, Address address) {
        this.fName = fName;
        this.sName = sName;
        this.email = email;
        this.address = address;
    }

    public Person(Long id, String fName, String sName, String email, Address address) {
        this.id = id;
        this.fName = fName;
        this.sName = sName;
        this.email = email;
        this.address = address;
    }

    public Person(Long id, String fName, String sName, String email) {
        this.id = id;
        this.fName = fName;
        this.sName = sName;
        this.email = email;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
