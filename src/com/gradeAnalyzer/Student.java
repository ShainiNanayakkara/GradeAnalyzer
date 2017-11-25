package com.gradeAnalyzer;

import java.util.ArrayList;

public class Student {
    String firstName;
    String LastName;
    String registrationNiumber;
    ArrayList<Integer> componentMarks = new ArrayList<Integer>();

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
}
