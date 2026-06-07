package codealpha;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Average Marks");
            System.out.println("4. Highest Marks");
            System.out.println("5. Lowest Marks");
            System.out.println("6. Search Student");
            System.out.println("7. Summary Report");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                // Add Student
                case 1:

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Roll Number: ");
                    int rollNo = sc.nextInt();

                    double marks;

                    while (true) {

                        System.out.print("Enter Marks (0 - 100): ");
                        marks = sc.nextDouble();

                        if (marks >= 0 && marks <= 100) {
                            break;
                        } 
                        else {
                            System.out.println("Invalid Marks! Please enter between 0 and 100.");
                        }
                    }

                    Student s = new Student(name, rollNo, marks);
                    students.add(s);

                    System.out.println("Student Added Successfully!");
                    break;

                // View Students
                case 2:

                    if (students.isEmpty()) {
                        System.out.println("No Student Data Found.");
                    } 
                    else {

                        System.out.println("\n===== STUDENT REPORT =====");
                        System.out.println("Name\tRollNo\tMarks\tGrade");

                        for (Student student : students) {
                            student.displayStudent();
                        }
                    }

                    break;

                // Average Marks
                case 3:

                    if (students.isEmpty()) {
                        System.out.println("No Student Data Found.");
                    } 
                    else {

                        double total = 0;

                        for (Student student : students) {
                            total += student.marks;
                        }

                        double average = total / students.size();

                        System.out.println("Average Marks: " + average);
                    }

                    break;

                // Highest Marks
                case 4:

                    if (students.isEmpty()) {
                        System.out.println("No Student Data Found.");
                    } 
                    else {

                        Student highest = students.get(0);

                        for (Student student : students) {

                            if (student.marks > highest.marks) {
                                highest = student;
                            }
                        }

                        System.out.println("\nHighest Marks Student:");
                        System.out.println("Name\tRollNo\tMarks\tGrade");
                        highest.displayStudent();
                    }

                    break;

                // Lowest Marks
                case 5:

                    if (students.isEmpty()) {
                        System.out.println("No Student Data Found.");
                    } 
                    else {

                        Student lowest = students.get(0);

                        for (Student student : students) {

                            if (student.marks < lowest.marks) {
                                lowest = student;
                            }
                        }

                        System.out.println("\nLowest Marks Student:");
                        System.out.println("Name\tRollNo\tMarks\tGrade");
                        lowest.displayStudent();
                    }

                    break;

                // Search Student
                case 6:

                    if (students.isEmpty()) {
                        System.out.println("No Student Data Found.");
                    } 
                    else {

                        System.out.print("Enter Roll Number to Search: ");
                        int searchRoll = sc.nextInt();

                        boolean found = false;

                        for (Student student : students) {

                            if (student.rollNo == searchRoll) {

                                System.out.println("\nStudent Found:");
                                System.out.println("Name\tRollNo\tMarks\tGrade");
                                student.displayStudent();

                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Student Not Found!");
                        }
                    }

                    break;

                // Summary Report
                case 7:

                    if (students.isEmpty()) {
                        System.out.println("No Student Data Found.");
                    } 
                    else {

                        double total = 0;
                        int passCount = 0;
                        int failCount = 0;

                        Student highest = students.get(0);
                        Student lowest = students.get(0);

                        for (Student student : students) {

                            total += student.marks;

                            if (student.marks > highest.marks) {
                                highest = student;
                            }

                            if (student.marks < lowest.marks) {
                                lowest = student;
                            }

                            if (student.marks >= 40) {
                                passCount++;
                            } 
                            else {
                                failCount++;
                            }
                        }

                        double average = total / students.size();

                        System.out.println("\n===== CLASS SUMMARY REPORT =====");
                        System.out.println("Total Students : " + students.size());
                        System.out.println("Average Marks  : " + average);
                        System.out.println("Highest Marks  : " + highest.name + " - " + highest.marks);
                        System.out.println("Lowest Marks   : " + lowest.name + " - " + lowest.marks);
                        System.out.println("Pass Students  : " + passCount);
                        System.out.println("Fail Students  : " + failCount);
                    }

                    break;

                // Exit
                case 8:

                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}