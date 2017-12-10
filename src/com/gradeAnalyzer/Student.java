package com.gradeAnalyzer;

import java.util.ArrayList;
import java.util.Comparator;

public class Student {
    private String firstName;
    private String LastName;
    private String registrationNiumber;
    private ArrayList<Integer> componentMarks = new ArrayList<Integer>();
    private double totalModuleMark;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getRegistrationNiumber() {
        return registrationNiumber;
    }

    public void setRegistrationNiumber(String registrationNiumber) {
        this.registrationNiumber = registrationNiumber;
    }

    public ArrayList<Integer> getComponentMarks() {
        return componentMarks;
    }

    public void setComponentMarks(ArrayList<Integer> componentMarks) {
        this.componentMarks = componentMarks;
    }

    public double getTotalModuleMark() {
        return totalModuleMark;
    }

    public void setTotalModuleMark(double totalModuleMark) {
        this.totalModuleMark = totalModuleMark;
    }

    // Comparator for sorting the student list by total module marks obtained
    public static Comparator<Student> StudentTotalModuleMarks = new Comparator<Student>() {

        public int compare(Student student1, Student student2) {

            int marks1 = student1.getComponentMarks().get(0);
            int marks2 = student2.getComponentMarks().get(0);

            // descending order
            return marks2-marks1;

        }};

    // Comparator for sorting the list by student lastname
    public static Comparator<Student> StudentLastNameComparator = new Comparator<Student>() {

        public int compare(Student student1, Student student2) {
            String StudentName1 = student1.getLastName().toUpperCase();
            String StudentName2 = student2.getLastName().toUpperCase();

            // ascending order
            return StudentName1.compareTo(StudentName2);

        }};
}
