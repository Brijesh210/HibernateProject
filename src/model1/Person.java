package model1;

import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Brijesh
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Persons")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    private String fName;

    private String sName;

    private String email;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "address_id", foreignKey = @javax.persistence.ForeignKey(name = "fk_person_address"))
    private Address address;

    public Person() {
    }

    public Person(Long id, String fName, String sName, String email) {
        this.id = id;
        this.fName = fName;
        this.sName = sName;
        this.email = email;

    }

    public Person(String fName, String sName, String email) {
        this.fName = fName;
        this.sName = sName;
        this.email = email;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
