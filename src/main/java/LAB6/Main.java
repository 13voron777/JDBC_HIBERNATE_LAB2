package LAB6;

import LAB6.entity.GrupEntity;
import LAB6.entity.StudentEntity;
import LAB6.entity.TeacherEntity;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        TeacherHelper th = new TeacherHelper();

        TeacherEntity teacher1 = new TeacherEntity();
        teacher1.setIdteacher(3);
        teacher1.setName("test");
        teacher1.setLastname("testov");
        teacher1.setPhone("+49 555 555 555");
        th.addTeacher(teacher1);

        TeacherEntity teacher2 = new TeacherEntity();
        teacher2.setIdteacher(4);
        teacher2.setName("Ben");
        teacher2.setLastname("Fridrich");
        teacher2.setPhone("+49 555 777 555");
        th.addTeacher(teacher2);

        // 1
        List<TeacherEntity> teacherList = th.getSelectionWhere();
        for (TeacherEntity teacher : teacherList) {
            System.out.println(teacher.getName() + " " + teacher.getLastname());
        }
        System.out.println();

        // 2
        th.deleteById(4);
        th.deleteCriteria();
        th.deleteCriteriaLogic();

        // 3
        GrupHelper gh = new GrupHelper();
        StudentHelper sh = new StudentHelper();

        List<GrupEntity> groupList = gh.getGroupList();
        for (GrupEntity group : groupList) {
            System.out.println(group.getIdgrup() + " "
                    + group.getMdirection() + " "
                    + group.getNum());
            List<StudentEntity> students = group.getStudents();
            for (StudentEntity student : students) {
                System.out.println("\t" + student.getIdstudent() + " "
                        + student.getName() + " " + student.getLastname()
                        + " " + student.getGrupid().getIdgrup());
            }
        }
        System.out.println();

        List<StudentEntity> students = sh.getStudentsList();
        for (StudentEntity student : students) {
            System.out.println(student.getIdstudent() + " "
                    + student.getName() + " " + student.getLastname()
                    + " " + student.getGrupid().getIdgrup());
        }
    }
}
