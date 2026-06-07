package codealpha;

public class Student {

    String name;
    int rollNo;
    double marks;

    // Constructor
    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // Grade Method
    String getGrade() {

        if (marks >= 90) {
            return "A";
        } 
        else if (marks >= 75) {
            return "B";
        } 
        else if (marks >= 60) {
            return "C";
        } 
        else if (marks >= 40) {
            return "D";
        } 
        else {
            return "Fail";
        }
    }

    // Display Student Details
    void displayStudent() {

        System.out.println(
                name + "\t" +
                rollNo + "\t" +
                marks + "\t" +
                getGrade());
    }
}