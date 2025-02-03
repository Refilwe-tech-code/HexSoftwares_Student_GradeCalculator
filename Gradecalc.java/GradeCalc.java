/*
***   PROBLEM STATEMENT  ***
Create a Student class with attributes like name, student ID, and an array of
 grades.
 Implement methods to calculate the average grade, display individual grades,
 and determine if the student has passed or failed.
 Include functionality to input multiple students and calculate the class average.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private String studentId;
    private List<Double> grades;

    public Student(String name, String studentId, List<Double> grades) {
        this.name = name;
        this.studentId = studentId;
        this.grades = grades;
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void displayGrades() {
        System.out.println("Grades for " + name + " (" + studentId + "): " + grades);
    }

    public boolean hasPassed(double passingGrade) {
        return calculateAverage() >= passingGrade;
    }
}

public class GradeCalc {
    public static List<Student> inputStudents() {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student ID: ");
            String studentId = scanner.nextLine();
            System.out.print("Enter grades separated by spaces: ");
            String[] gradesInput = scanner.nextLine().split(" ");
            List<Double> grades = new ArrayList<>();
            for (String grade : gradesInput) {
                grades.add(Double.parseDouble(grade));
            }
            students.add(new Student(name, studentId, grades));
        }
        scanner.close();
        return students;
    }

    public static double calculateClassAverage(List<Student> students) {
        if (students.isEmpty()) return 0;
        double totalAverage = 0;
        for (Student student : students) {
            totalAverage += student.calculateAverage();
        }
        return totalAverage / students.size();
    }

    public static void main(String[] args) {
        List<Student> students = inputStudents();
        for (Student student : students) {
            student.displayGrades();
            System.out.printf("Average Grade: %.2f\n", student.calculateAverage());
            System.out.println("Status: " + (student.hasPassed(50) ? "Passed" : "Failed"));
            System.out.println("-".repeat(30));
        }
        System.out.printf("Class Average: %.2f\n", calculateClassAverage(students));
    }
}
