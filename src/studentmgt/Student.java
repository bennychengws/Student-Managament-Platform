package studentmgt;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    static int numberOfStudents;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private char collegeID;
    private String studentID;
    private String password;
    private String facultyID = "nah";
    private String faculty;
    private String college;
    private String email;
    private final int mailboxCapacity = 1;
    private final int defaultPasswordLength = 10;
    private String semGpa;

    public Student(String firstName, String lastName, int age, String phoneNumber) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.college = setCollege();
        this.collegeID = setCollegeID();

        this.faculty = setfaculty();
        this.password = randomPassword();

        numberOfStudents ++;
        this.studentID = setStudentID();

        this.email = this.studentID + "@" + this.facultyID + "." + "university.hk";
    }

    public static String getNumberOfStudents() {
        return "\nNumber of students registered: " + numberOfStudents;
    }

    private String setCollege() {
        String[] colleges = {"Alexandra", "Pericles", "Thales", "Hippocrates"};
        int rand = (int) (Math.random() * colleges.length);
        return colleges[rand];
    }

    private char setCollegeID() {
        switch (this.college) {
            case "Alexandra":
                college = "Alexandra";
                return 'A';
            case "Pericles":
                college = "Pericles";
                return 'P';
            case "Thales":
                college = "Thales";
                return 'T';
            case "Hippocrates":
                college = "Hippocrates";
                return 'H';
            default:
                college = "Not yet assigned";
                return 'N';
        }
    }

    private String setStudentID() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String yearInString = String.valueOf(year);
        String numberOfStudentsInString = String.format("%03d", numberOfStudents);
        return yearInString + numberOfStudentsInString + collegeID;
    }


    public String setfaculty() throws Exception {
        int facChoice = 0;
        while (facChoice != 1 && facChoice != 2 && facChoice != 3 && facChoice != 4) {
            System.out.println("\nEnter the faculty according to the correct faculty codes");
            System.out.print("1 for Faculty of Science and Engineering\n2 for Faculty of Business\n3 for Faculty of Health and Environment\n4 for Faculty of Humanities\nEnter faculty code: ");
            Scanner scanner = new Scanner(System.in);
            try {
                facChoice = scanner.nextInt();
            } catch (InputMismatchException e1) {
                System.out.println("Please enter a numeric value");
            }
        }
        if (facChoice == 1) {
            this.facultyID = "se";
            return "Science and Engineering";
        } else if (facChoice == 2) {
            this.facultyID = "bba";
            return "Business";
        } else if (facChoice == 3) {
            this.facultyID = "he";
            return "Health and Environment";
        } else {
            this.facultyID = "human";
            return "Humanities";
        }
    }

    private String randomPassword() {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*~`";
        char[] password = new char[defaultPasswordLength];
        for (int i = 0; i < defaultPasswordLength; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void showInfo() {
        System.out.println("Display Name: " + firstName + " " + lastName +
                "\nStudentID: " + studentID +
                "\nPhone Number: " + phoneNumber +
                "\nPassword: " + password +
                "\nCollege: " + college +
                "\nFaculty: " + faculty +
                "\nStudent Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "gb" +
                "\nGPA: " + getSemGPA());
    }

    public double getSubjectScore(String subjectGrade) {
        switch (subjectGrade) {
            case "A+":
                return 4.5d;
            case "A":
                return 4.0d;
            case "B+":
                return 3.5d;
            case "B":
                return 3.0d;
            case "C+":
                return 2.5d;
            case "C":
                return 2.0d;
            case "D+":
                return 1.5d;
            case "D":
                return 1.0d;
            case "F":
                return 0.0d;
            default:
                return 0.0d;
        }
    }

    public String getSemGPA() {
        return semGpa;
    }

    public void isDeanList(String gpa) {
        double gpaForDeanList = Double.parseDouble(gpa);
        System.out.println("Primarily in faculty's Dean List or not: " + (gpaForDeanList >= 3.5));
    }
}
