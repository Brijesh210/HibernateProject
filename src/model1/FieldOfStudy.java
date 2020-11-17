package model1;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Brijesh
 */
@Entity
@Table(name = "FieldOfStudies")
public class FieldOfStudy implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_of_study_id")
    private Long id;
   
    private String name;
    
    private String type;

    @OneToMany(mappedBy = "fieldOfStudys")
    private Set<Student> students = new HashSet<>();

    public FieldOfStudy(String name, String type, Set<Student> students) {
        this.name = name;
        this.type = type;
        this.students = students;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public FieldOfStudy() {
    }
    
    public FieldOfStudy(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public FieldOfStudy(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FieldOfStudy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
