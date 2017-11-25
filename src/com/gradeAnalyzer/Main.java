package com.gradeAnalyzer;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numOfStudents = 0, index = 0;
        Scanner scanner = new Scanner(System.in);
        // Create an student array to store student details
        ArrayList<Student> students = new ArrayList<Student>();

        // Expect int value
        System.out.print("Enter number of Students");
        numOfStudents = scanner.nextInt();
        System.out.println("You are required to enter marks for " +numOfStudents+ " students");


        while (index < numOfStudents) {
            //Create temporary student object
            Student tempStudent = new Student();
            System.out.println("Enter Student no: "+(index+1)+ " details");

            System.out.println("First Name: ");
            tempStudent.setFirstName(scanner.next());

            System.out.println("Second Name: ");
            tempStudent.setLastName(scanner.next());

            System.out.println("Registration Number: ");
            tempStudent.setRegistrationNiumber(scanner.next());

            System.out.println("Marks for ICT 01");
            tempStudent.getComponentMarks().add(scanner.nextInt());

            System.out.println("Marks for ICT 02");
            tempStudent.getComponentMarks().add(scanner.nextInt());

            System.out.println("Marks for Group CWK 01");
            tempStudent.getComponentMarks().add(scanner.nextInt());

            System.out.println("Marks for Group CWK 02");
            tempStudent.getComponentMarks().add(scanner.nextInt());

            students.add(tempStudent);
            index++;

        }

        System.out.println("---Successfully obtained student records---");
        System.out.println("---Processing---");
        System.out.println("---Student values are as follows---");

        for(int studentIndex = 0; studentIndex < students.size(); studentIndex ++) {
            System.out.println("Student no: " + (studentIndex+1) +  " details");
            System.out.println("First Name: " + students.get(studentIndex).getFirstName());
            System.out.println("Last Name: " + students.get(studentIndex).getLastName());
            System.out.println("Registration Number: " + students.get(studentIndex).getRegistrationNiumber());

            System.out.println("ICT 01 Marks: " + students.get(studentIndex).getComponentMarks().get(0));
            System.out.println("ICT 02 Marks: " + students.get(studentIndex).getComponentMarks().get(1));
            System.out.println("Group CWK 01 Marks: " + students.get(studentIndex).getComponentMarks().get(2));
            System.out.println("Group CWK 02 Marks: " + students.get(studentIndex).getComponentMarks().get(3));
        }

    }
}
