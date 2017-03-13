import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by staho on 12.03.2017.
 */
public class University {
    private List<Student> universityStudents = new ArrayList<>();

    private List<Activity> universityActivities = new ArrayList<>();

    //i
    public void addStudent(String name, String surname, StudentType type){
        universityStudents.add(new Student(name, surname, type));
    }
    public void addStudent(){
        universityStudents.add(new Student());
    }

    //ii
    public void addActivity(String name){
        universityActivities.add(new Activity(name));
    }

    //iii
    public void addStudentToActivity(Student student, Activity activity){
        student.addActivityToList(activity);
        activity.addStudentToSet(student);
    }

    //iv
    public void deleteStudent(Student student){
        universityStudents.remove(student);
        for(int i = 0; i < universityActivities.size(); ++i){
            universityActivities.get(i).deleteStudentFromSet(student);
        }
    }

    //v
    public void deleteStudentIndex(int index){
        for(int i = 0; i < universityStudents.size(); ++i) {
            if( universityStudents.get(i).getIid() == index) deleteStudent(universityStudents.get(i));
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
        Queue<Student> tempStudentQueue = new ConcurrentLinkedQueue<>();
        for (Iterator<Student> student = universityStudents.iterator(); student.hasNext();) {
            Student temp = student.next();
            if(temp.isStudentActivitiesEmpty()) tempStudentQueue.add(temp);
        }

        return tempStudentQueue;
    }

    //ix
    public Stack<Student> studentsWithNActivities(int n){
        Stack<Student> tempStudentStack = new Stack<>();
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
    public void printStudentsAlphabetically(){
        Comparator<Student> cmp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int compared = o1.getSurname().compareTo(o2.getSurname());
                if(compared == 0) compared = o1.getName().compareTo(o2.getName());
                return compared;
            }
        };
        universityStudents.sort(cmp);
        for (Iterator<Student> student = universityStudents.iterator(); student.hasNext();) {
            Student temp = student.next();
            System.out.println(temp.getSurname() + " " + temp.getName() + " IID: " + temp.getIid());
        }

    }

    //xiii
    public boolean doesActivitiesHaveTheSameStudents(Activity activity1, Activity activity2){
        return Collections.disjoint(activity1.getAssignedStudents(), activity2.getAssignedStudents());
    }

    //additional methods
    public Activity getActivityFromList(int index){
        if(index > 0 && index <= universityActivities.size()){
            return universityActivities.get(index - 1);
        }
        else {
            return new Activity("Kappa :v - zły index");
        }
    }

    public Student getStudentFromList(int index){
        if(index > 0 && index <= universityStudents.size()){
            return universityStudents.get(index - 1);
        }
        else {
            return new Student("Kappa :v - zły index");
        }
    }
    public void printStudent(Student student){
        System.out.println(student.getSurname() + " " + student.getName() + " IID: " + student.getIid());
    }
}
