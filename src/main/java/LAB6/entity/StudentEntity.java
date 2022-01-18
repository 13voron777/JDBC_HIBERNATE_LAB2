package LAB6.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "academy")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idstudent")
    private int idstudent;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grupid")
    private GrupEntity grupid;

    public StudentEntity() {
    }

    public GrupEntity getGroupid() {
        return grupid;
    }

    public void setGroupid(GrupEntity grupid) {
        this.grupid = grupid;
    }

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return idstudent == that.idstudent && Objects.equals(name, that.name)
                && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idstudent, name, lastname);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "idstudent=" + idstudent +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", grup=" + grupid +
                '}';
    }
}
