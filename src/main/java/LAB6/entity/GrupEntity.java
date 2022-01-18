package LAB6.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "grup", schema = "academy")
public class GrupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgrup")
    private int idgrup;

    @Basic
    @Column(name = "mdirection")
    private String mdirection;

    @Basic
    @Column(name = "num")
    private int num;

    @OneToMany(mappedBy = "grupid", fetch = FetchType.EAGER)
    private List<StudentEntity> students = new ArrayList<>();

    public GrupEntity() {
    }

    public List<StudentEntity> getStudents() {
      return students;
    }

    public void setStudents(List<StudentEntity> students) {
      this.students = students;
    }

    public int getIdgrup() {
        return idgrup;
    }

    public void setIdgrup(int idgrup) {
        this.idgrup = idgrup;
    }

    public String getMdirection() {
        return mdirection;
    }

    public void setMdirection(String mdirection) {
        this.mdirection = mdirection;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupEntity that = (GrupEntity) o;
        return  idgrup == that.idgrup
                && Objects.equals(mdirection, that.mdirection)
                && num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idgrup, mdirection, num);
    }

    @Override
    public String toString() {
        return "GrupEntity{" +
                "idgrup=" + idgrup +
                ", direction='" + mdirection + '\'' +
                ", number=" + num +
                '}';
    }
}

