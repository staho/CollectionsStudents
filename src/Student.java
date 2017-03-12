/**
 * Created by staho on 12.03.2017.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements Comparable<Student>{
    private static int id;
    private int iid;
    private String name, surname;
    private StudentType typStudenta;
    private List<Activity> studentActivities = new ArrayList<Activity>();

    public int getIid() {
        return iid;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public StudentType getTypStudenta() {
        return typStudenta;
    }

    public void setTypStudenta(StudentType typStudenta) {
        this.typStudenta = typStudenta;
    }

    public Student(String name, String surname, StudentType typStudenta) {
        iid = ++id;
        this.name = name;
        this.surname = surname;
        this.typStudenta = typStudenta;
    }

    public Student() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the name: ");
        this.name = s.nextLine();
        System.out.println("Enter the surname: ");
        this.surname = s.nextLine();

        System.out.println("Is student: ");
        System.out.println("1 - stationary");
        System.out.println("2 - nonstationary");
        System.out.println("3 - postgraduate");

        boolean isChoiceGood = false;
        while (!isChoiceGood) {
            switch (s.nextInt()) {
                case 1:
                    this.typStudenta = StudentType.STATIONARY;
                    isChoiceGood = true;
                    break;
                case 2:
                    this.typStudenta = StudentType.NONSTATIONARY;
                    isChoiceGood = true;
                    break;
                case 3:
                    this.typStudenta = StudentType.POSTGRADUATE;
                    isChoiceGood = true;
                    break;
                default:
                    System.out.println("Wrong choice!");
            }
        }

    }

    public Student(String xxx) {
        this.name = new String("Cos nie tak");
        this.surname = xxx;
    }

    @Override
    public int compareTo(Student x){
        int comparedSurnames = surname.compareTo(x.surname);

        if(comparedSurnames == 0){
            return name.compareTo(x.name);
        }
        else {
            return comparedSurnames;
        }
    }

    public void addActivityToList(Activity activity){
        studentActivities.add(activity);
    }
    public boolean isStudentActivitiesEmpty(){
        if(studentActivities.size() == 0) { return true; }
        else return false;
    }
    public int howManyActivitiesStudentHave(){
        return studentActivities.size();
    }
}
