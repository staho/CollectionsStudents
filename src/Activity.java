/**
 * Created by staho on 12.03.2017.
 */
import java.util.*;

public class Activity {
    private String name;
    private Set<Student> assignedStudents = new TreeSet<Student>();

    public Activity(String name) {
        this.name = name;
    }
    public void addStudentToSet(Student student){
        assignedStudents.add(student);
    }
    public void deleteStudentFromSet(Student student){
        assignedStudents.remove(student);
    }
    public void deleteAllStudentsFromSet(){
        assignedStudents.clear();
    }
    public boolean isStudentAssigned(Student student){
        return assignedStudents.contains(student);
    }
}
