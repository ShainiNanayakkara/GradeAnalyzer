package com.gradeAnalyzer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Variable declaration
        int numberOfStudents=0, index = 0;
        Scanner scanner = new Scanner(System.in);
        int averageICT01, averageICT02, averageGroupCW1, averageGroupCW2;
        double overalClassAverage;

        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Integer> componentAverages = new ArrayList<Integer>();
        ArrayList<Integer> lessThanThresholdldStudents = new ArrayList<Integer>();
        ArrayList<ArrayList<Student>> categorizedStudents = new ArrayList<ArrayList<Student>>();
        ArrayList<Student> heighstScoringStudents = new ArrayList<Student>();
        Student lowestScoringStudent = new Student();
        ArrayList<Student> retakeStudents = new ArrayList<Student>();
        ArrayList<ArrayList<Student>> resitStudents = new ArrayList<ArrayList<Student>>();
        ArrayList<Integer> displayStats = new ArrayList<Integer>();

        try
        {
            System.out.print("Enter number of Students");
            numberOfStudents = scanner.nextInt();
            System.out.println("You are required to enter marks for " + numberOfStudents + " students");

            while (index < numberOfStudents) {
                //Create temporary student object
                Student tempStudent = new Student();
                System.out.println("Enter Student no: " + (index + 1) + " details");

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

            System.out.println("1,2,3---Successfully obtained student records---");
            System.out.println("---Processing---");
            System.out.println("---Student values are as follows---");

            for (int studentIndex = 0; studentIndex < students.size(); studentIndex++) {
                System.out.println("Student no: " + (studentIndex + 1) + " details");
                System.out.println("First Name: " + students.get(studentIndex).getFirstName());
                System.out.println("Last Name: " + students.get(studentIndex).getLastName());
                System.out.println("Registration Number: " + students.get(studentIndex).getRegistrationNiumber());

                System.out.println("ICT 01 Marks: " + students.get(studentIndex).getComponentMarks().get(0));
                System.out.println("ICT 02 Marks: " + students.get(studentIndex).getComponentMarks().get(1));
                System.out.println("Group CWK 01 Marks: " + students.get(studentIndex).getComponentMarks().get(2));
                System.out.println("Group CWK 02 Marks: " + students.get(studentIndex).getComponentMarks().get(3));
            }

            // Individual Component Averages
            System.out.println("4---Individual Component Average---");
            componentAverages = Util.getComponentAverage(students, numberOfStudents);
            averageICT01 = componentAverages.get(0);
            averageICT02 = componentAverages.get(1);
            averageGroupCW1 = componentAverages.get(2);
            averageGroupCW2 = componentAverages.get(3);
            System.out.println("ICT01 class average  " + averageICT01);
            System.out.println("ICT02 class average  " + averageICT02);
            System.out.println("GroupCW1 class average  " + averageGroupCW1);
            System.out.println("GroupCW2 class average  " + averageGroupCW2);


            // student count less than 30
            System.out.println("5--Student count less than 30 for each component");
            lessThanThresholdldStudents = Util.getStudentsBelowThreshold(students, 30);
            System.out.println("Number of students obtaining less than 30 for ICT01  " + lessThanThresholdldStudents.get(0));
            System.out.println("Number of students obtaining less than 30 for ICT02  " + lessThanThresholdldStudents.get(1));
            System.out.println("Number of students obtaining less than 30 for GroupCW1  " + lessThanThresholdldStudents.get(2));
            System.out.println("Number of students obtaining less than 30 for GroupCW2  " + lessThanThresholdldStudents.get(3));

            // Overall Class Averages
            System.out.println("6--Overall Class Average--");
            overalClassAverage = Util.getClassAverage(componentAverages);
            System.out.println("Overall Class Average for " + numberOfStudents + " students is: " + overalClassAverage);


            categorizedStudents = Util.categorizedStudents(students, overalClassAverage);
            System.out.println("7--Students obtaining overall mark below the class average");
            for(int i=0; i < categorizedStudents.get(0).size(); i++) {
                System.out.println(categorizedStudents.get(0).get(i).getFirstName() + " " +
                        categorizedStudents.get(0).get(i).getLastName() + " - " +
                        categorizedStudents.get(0).get(i).getRegistrationNiumber());
            }

            System.out.println("8--Students obtaining overall above or equal to class average in decending order of the module mark");

            // Sorting on totalModuleMark property
            Collections.sort(categorizedStudents.get(1), Student.StudentTotalModuleMarks);
            for(Student student: categorizedStudents.get(1)){
                System.out.println(student.getFirstName() + " " +
                        student.getLastName() + " - " +
                        student.getRegistrationNiumber());
            }

            System.out.println("9--Heights scoring student details--");
            heighstScoringStudents = Util.getStudentHeighstScoringStats(students);
            System.out.println("Heighst scoring student for ICT01: " + heighstScoringStudents.get(0).getFirstName() + " " +
                    heighstScoringStudents.get(0).getLastName() + " - " + heighstScoringStudents.get(0).getRegistrationNiumber());

            System.out.println("Heighst scoring student for ICT02: " + heighstScoringStudents.get(1).getFirstName() + " " +
                    heighstScoringStudents.get(1).getLastName() + " - " + heighstScoringStudents.get(1).getRegistrationNiumber());

            System.out.println("Heighst scoring student for GroupCW01: " + heighstScoringStudents.get(2).getFirstName() + " " +
                    heighstScoringStudents.get(2).getLastName() + " - " + heighstScoringStudents.get(2).getRegistrationNiumber());

            System.out.println("Heighst scoring student for GroupCW02: " + heighstScoringStudents.get(3).getFirstName() + " " +
                    heighstScoringStudents.get(3).getLastName() + " - " + heighstScoringStudents.get(3).getRegistrationNiumber());

            System.out.println("Heighst scoring student for overall module: " + heighstScoringStudents.get(4).getFirstName() + " " +
                    heighstScoringStudents.get(4).getLastName() + " - " + heighstScoringStudents.get(4).getRegistrationNiumber());

            System.out.println("10--Lowest scoring student for the module--");
            lowestScoringStudent = Util.getLowestScoringStudent(students);
            System.out.println("Lowest scorer for the module: " + lowestScoringStudent.getFirstName() + " " +
                    lowestScoringStudent.getLastName() + " - " + lowestScoringStudent.getRegistrationNiumber());

            System.out.println("11--Retake student list--");
            retakeStudents = Util.getRetakeStudentList(students, 30);
            for (int i=0; i < retakeStudents.size(); i++ ) {
                System.out.println(retakeStudents.get(i).getFirstName() + " " + retakeStudents.get(i).getLastName()
                        + " - " + retakeStudents.get(i).getRegistrationNiumber());
            }

            System.out.println("12--Resit student list--");
            resitStudents = Util.getResitStudentList(students, 30);

            System.out.println("Resit student details - ICT components");

            if (resitStudents.get(0).size() == 0) {
                System.out.println("No students resit ICT components");
            }

            // Sorting on lastname property for resit student - ICT
            Collections.sort(resitStudents.get(0), Student.StudentLastNameComparator);
            for(Student student: resitStudents.get(0)){
                // System.out.println(str);
                System.out.println(student.getFirstName() + " " +
                        student.getLastName() + " - " +
                        student.getRegistrationNiumber());
            }


            System.out.println("Resit student details - GroupCW1");

            if (resitStudents.get(1).size() == 0) {
                System.out.println("No students resit GroupCW1 component");
            }

            // Sorting on lastname property for resit student - GroupCW1
            Collections.sort(resitStudents.get(1), Student.StudentLastNameComparator);
            for(Student student: resitStudents.get(1)){
                // System.out.println(str);
                System.out.println(student.getFirstName() + " " +
                        student.getLastName() + " - " +
                        student.getRegistrationNiumber());
            }


            System.out.println("Resit student details - GroupCW2");

            if (resitStudents.get(2).size() == 0) {
                System.out.println("No students resit GroupCW2 component");
            }

            // Sorting on lastname property for resit student - GroupCW2
            Collections.sort(resitStudents.get(2), Student.StudentLastNameComparator);
            for(Student student: resitStudents.get(2)){
                // System.out.println(str);
                System.out.println(student.getFirstName() + " " +
                        student.getLastName() + " - " +
                        student.getRegistrationNiumber());
            }

            //Display stats calculation
            displayStats = Util.getGraphicalDisplayStats(students);
            System.out.println("111:: " + displayStats.get(0));
            System.out.println("222:: " + displayStats.get(1));
            System.out.println("333:: " + displayStats.get(2));
            System.out.println("444:: " + displayStats.get(3));

            //Results displaying on JFrame
            JFrame frameToDisplayResultsVertically = new JFrame("Overall Results - Vertical View");
            frameToDisplayResultsVertically.add(new VerticalResultsDisplay(displayStats));
            frameToDisplayResultsVertically.setSize(300, 300);
            frameToDisplayResultsVertically.setVisible(true);
            frameToDisplayResultsVertically.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JFrame frameToDisplayResultsHorizontally = new JFrame("Overall Results - Horizontal View");
            frameToDisplayResultsHorizontally.add(new HorizontalResultsDisplay(displayStats));
            frameToDisplayResultsHorizontally.setSize(300, 300);
            frameToDisplayResultsHorizontally.setVisible(true);
            frameToDisplayResultsHorizontally.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(InputMismatchException exception)
        {
            System.out.println("Incorrect Input Value !!!");
        }

    }

}

class VerticalResultsDisplay extends JPanel {
    int rowSpace;
    int initialHight = 50;
    ArrayList<Integer> displayStats;
    VerticalResultsDisplay(ArrayList<Integer> displayStats) {
        this.displayStats = displayStats;
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D verticalDisplay = (Graphics2D) g;
        verticalDisplay.setColor(Color.BLACK);
        // marks categories added
        verticalDisplay.drawString("0-29", 0, 10);
        verticalDisplay.drawString("30-39", 50, 10);
        verticalDisplay.drawString("40-69", 100, 10);
        verticalDisplay.drawString("70-100", 150, 10);

        // 0-29
        rowSpace = initialHight;
        for(int i=0; i<this.displayStats.get(0); i++) {
            verticalDisplay.drawString("*", 0, rowSpace);
            rowSpace += 10;
        }

        // 30-39
        rowSpace = initialHight;
        for(int i=0; i<this.displayStats.get(1); i++) {
            verticalDisplay.drawString("*", 50, rowSpace);
            rowSpace += 10;
        }

        // 40-69
        rowSpace = initialHight;
        for(int i=0; i<this.displayStats.get(2); i++) {
            verticalDisplay.drawString("*", 100, rowSpace);
            rowSpace += 10;
        }

        //70-100
        rowSpace = initialHight;
        for(int i=0; i<this.displayStats.get(3); i++) {
            verticalDisplay.drawString("*", 150, rowSpace);
            rowSpace += 10;
        }


    }
}

class HorizontalResultsDisplay extends JPanel {
    ArrayList<Integer> displayStats = new ArrayList<Integer>();
    int columnWidth;
    int initialWidth = 50;
    HorizontalResultsDisplay(ArrayList<Integer> displayStats) {
        this.displayStats = displayStats;
    }
    @Override
    public void paint(Graphics g) {

        Graphics2D horizontalDisplay = (Graphics2D) g;
        horizontalDisplay.setColor(Color.BLACK);
        horizontalDisplay.drawString("0-29", 0, 10);
        horizontalDisplay.drawString("30-39", 0, 60);
        horizontalDisplay.drawString("40-69", 0, 110);
        horizontalDisplay.drawString("70-100", 0, 160);

        // 0-29
        columnWidth = initialWidth;
        for(int i=0; i<this.displayStats.get(0); i++) {
            horizontalDisplay.drawString("*", columnWidth, 10);
            columnWidth += 10;
        }

        // 30-39
        columnWidth = initialWidth;
        for(int i=0; i<this.displayStats.get(1); i++) {
            horizontalDisplay.drawString("*", columnWidth, 60);
            columnWidth += 10;
        }

        // 40-69
        columnWidth = initialWidth;
        for(int i=0; i<this.displayStats.get(2); i++) {
            horizontalDisplay.drawString("*", columnWidth, 110);
            columnWidth += 10;
        }

        //70-100
        columnWidth = initialWidth;
        for(int i=0; i<this.displayStats.get(3); i++) {
            horizontalDisplay.drawString("*", columnWidth, 160);
            columnWidth += 10;
        }
    }
}
