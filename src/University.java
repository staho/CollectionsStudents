import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

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
            if( universityStudents.get(i).getIid() == x) deleteStudent(universityStudents.get(i));
        }
    }

    //vi
    public void deleteStudentsFromActivity(Activity activity){
        activity.deleteAllStudentsFromSet();
    }

    //vii
    public boolean isStudentAssignedToActivity(Student student, Activity activity){
        return activity.isStudentAssigned(student);
    }

    //viii
    public Queue<Student> notAssignedStudentsQueue(){
        Queue<Student> tempStudentQueue = new ConcurrentLinkedQueue<Student>();
        for (Iterator<Student> student = universityStudents.iterator(); student.hasNext();) {
            Student temp = student.next();
            if(temp.isStudentActivitiesEmpty()) tempStudentQueue.add(temp);
        }

        return tempStudentQueue;
    }

    //ix
    public Stack<Student> studentsWithNActivities(int n){
        Stack<Student> tempStudentStack = new Stack<Student>();
        for (Iterator<Student> student = universityStudents.iterator(); student.hasNext();) {
            Student temp = student.next();
            if(temp.howManyActivitiesStudentHave() == n) tempStudentStack.push(temp);
        }
        return tempStudentStack;
    }

    //x
    public Student studentWithMaxNoOfActivities(){
        Comparator<Student> cmp = (o1, o2) -> Integer.compare(o1.howManyActivitiesStudentHave(), o2.howManyActivitiesStudentHave());
        return Collections.max(universityStudents, cmp);
    }

    //xi
    public Map<StudentType, Integer> mapOfParticularStudentTypes(){
        Map<StudentType, Integer> tempMap = new HashMap<>();
        tempMap.put(StudentType.STATIONARY, new Integer(0));
        tempMap.put(StudentType.NONSTATIONARY, new Integer(0));
        tempMap.put(StudentType.POSTGRADUATE, new Integer(0));

        for (Iterator<Student> student = universityStudents.iterator(); student.hasNext();) {
            Student temp = student.next();
            int studentTypeCount = tempMap.get(temp.getTypStudenta());
            tempMap.put(temp.getTypStudenta(), new Integer(studentTypeCount + 1));
        }

        return tempMap;
    }

    //xii
    //public void printStudentsAlphabetically(){
      //  universityStudents.sort();
  //  }
}
