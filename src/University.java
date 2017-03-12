import java.util.*;

/**
 * Created by staho on 12.03.2017.
 */
public class University {
    private List<Student> universityStudents = new ArrayList<Student>();

    private List<Activity> univeristyActivities = new ArrayList<Activity>();

    //i
    public void addStudent(String name, String surname, StudentType type){
        universityStudents.add(new Student(name, surname, type));
    }
    public void addStudent(){
        universityStudents.add(new Student());
    }

    //ii
    public void addActivity(String name){
        univeristyActivities.add(new Activity(name));
    }

    //iii
    public void addStudentToActivity(Student student, Activity activity){
        student.addActivityToList(activity);
        activity.addStudentToSet(student);
    }

    //iv
    public void deleteStudent(Student student){
        universityStudents.remove(student);
        for(int i = 0; i < univeristyActivities.size(); ++i){
            univeristyActivities.get(i).deleteStudentFromSet(student);
        }
    }

    //v
    public void deleteStudentIndex(int x){
        for(int i = 0; i < universityStudents.size(); ++i) {
            if( universityStudents.get(i).getIid() == x){
                deleteStudent(universityStudents.get(i));
            }
        }
    }

    //vi
    public void deleteStudentsFromActivity(Activity activity){
        activity.deleteAllStudentsFromSet();
    }

    //vii
    public boolean isStudentAssignedToActivity(Student student, Activity activity){

    }
}
