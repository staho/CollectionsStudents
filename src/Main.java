/**
 * Created by staho on 12.03.2017.
 */

/**
 * All specification to this project you can find under following address
 * http://home.agh.edu.pl/~kbzowski/JAVA/LAB2.pdf
 */
public class Main {
    public static void main(String args[]){

        University university = new University();
        university.addActivity("Programming in Java");
        university.addActivity("Computer Networks");
        university.addActivity("Physical education");
        university.addActivity("Numeric Methods");

        university.addStudent("Kamil","Stachowicz", StudentType.STATIONARY);
        university.addStudent("Michal", "Radziejowski", StudentType.STATIONARY);
        university.addStudent("Msciwor", "Potworek", StudentType.STATIONARY);
        university.addStudent("Grazyna","Brzeczyszczykiewicz", StudentType.STATIONARY);

        university.addStudent("Anna", "Maria", StudentType.NONSTATIONARY);
        university.addStudent("Zbyszek", "Szatan", StudentType.NONSTATIONARY);

        university.addStudent("Krzysztof", "Gonciarz", StudentType.POSTGRADUATE);

        university.addStudentToActivity(university.getStudentFromList(1), university.getActivityFromList(1));
        university.addStudentToActivity(university.getStudentFromList(1), university.getActivityFromList(2));
        university.addStudentToActivity(university.getStudentFromList(1), university.getActivityFromList(3));
        university.addStudentToActivity(university.getStudentFromList(1), university.getActivityFromList(4));

        university.addStudentToActivity(university.getStudentFromList(2), university.getActivityFromList(1));
        university.addStudentToActivity(university.getStudentFromList(2), university.getActivityFromList(3));

        university.addStudentToActivity(university.getStudentFromList(3), university.getActivityFromList(4));

        university.addStudentToActivity(university.getStudentFromList(4), university.getActivityFromList(2));
        university.addStudentToActivity(university.getStudentFromList(4), university.getActivityFromList(3));

        university.addStudentToActivity(university.getStudentFromList(5), university.getActivityFromList(2));

        university.addStudentToActivity(university.getStudentFromList(6), university.getActivityFromList(3));
        university.addStudentToActivity(university.getStudentFromList(6), university.getActivityFromList(4));




    }
}
