package com.gradeAnalyzer;

import java.util.ArrayList;

public class Util {

    public static ArrayList<Integer> getComponentAverage(ArrayList<Student> students, int numberOfStudents) {
        ArrayList<Integer> classAverageForComponents = new ArrayList<Integer>();
        int tempICT01Marks = 0;
        int tempICT02Marks = 0;
        int tempGroupCW1Marks = 0;
        int tempGroupCW2Marks = 0;
        for (int studentIndex = 0; studentIndex < students.size(); studentIndex++) {
            tempICT01Marks = tempICT01Marks + students.get(studentIndex).getComponentMarks().get(0);
            tempICT02Marks = tempICT02Marks + students.get(studentIndex).getComponentMarks().get(1);
            tempGroupCW1Marks = tempGroupCW1Marks + students.get(studentIndex).getComponentMarks().get(2);
            tempGroupCW2Marks = tempGroupCW2Marks + students.get(studentIndex).getComponentMarks().get(3);
        }
        classAverageForComponents.add(tempICT01Marks/numberOfStudents);
        classAverageForComponents.add(tempICT02Marks/numberOfStudents);
        classAverageForComponents.add(tempGroupCW1Marks/numberOfStudents);
        classAverageForComponents.add(tempGroupCW2Marks/numberOfStudents);

        return classAverageForComponents;
    }

    public static double getClassAverage(ArrayList<Integer> componentAverage) {
        double tempClassAverage;
        tempClassAverage = componentAverage.get(0)*0.20
                + componentAverage.get(1)*0.20
                + componentAverage.get(2)*0.30
                + componentAverage.get(3)*0.30;

        return tempClassAverage;
    }

    public static ArrayList<Integer> getStudentsBelowThreshold(ArrayList<Student> students, int threshould) {
        ArrayList<Integer> numberOfStudentsBelowThreshould = new ArrayList<Integer>();
        int tempICT01Marks = 0;
        int tempICT02Marks = 0;
        int tempGroupCW1Marks = 0;
        int tempGroupCW2Marks = 0;

        for (int studentIndex = 0; studentIndex < students.size(); studentIndex++) {
            if (students.get(studentIndex).getComponentMarks().get(0) < threshould) {
                tempICT01Marks++;
            }
            if (students.get(studentIndex).getComponentMarks().get(1) < threshould) {
                tempICT02Marks++;
            }
            if (students.get(studentIndex).getComponentMarks().get(2) < threshould) {
                tempGroupCW1Marks++;
            }
            if (students.get(studentIndex).getComponentMarks().get(3) < threshould) {
                tempGroupCW2Marks++;
            }
        }
        numberOfStudentsBelowThreshould.add(tempICT01Marks);
        numberOfStudentsBelowThreshould.add(tempICT02Marks);
        numberOfStudentsBelowThreshould.add(tempGroupCW1Marks);
        numberOfStudentsBelowThreshould.add(tempGroupCW2Marks);

        return numberOfStudentsBelowThreshould;

    }

    public static ArrayList<ArrayList<Student>> categorizedStudents(ArrayList<Student> students, double classAverage) {
        ArrayList<ArrayList<Student>> categorizedStudents = new ArrayList<ArrayList<Student>>();
        ArrayList<Student> studentsMoreThanClassAverage = new ArrayList<Student>();
        ArrayList<Student> studentsLessThanClassAverage = new ArrayList<Student>();

        double tempTotalModuleMarks;

        for (int studentIndex = 0; studentIndex < students.size(); studentIndex++) {
            tempTotalModuleMarks = calculateTotalModuleMarks(students.get(studentIndex));

            if (tempTotalModuleMarks >= classAverage) {
                students.get(studentIndex).setTotalModuleMark(tempTotalModuleMarks);
                studentsMoreThanClassAverage.add(students.get(studentIndex));
            } else {
                students.get(studentIndex).setTotalModuleMark(tempTotalModuleMarks);
                studentsLessThanClassAverage.add(students.get(studentIndex));
            }
        }
        categorizedStudents.add(studentsLessThanClassAverage);
        categorizedStudents.add(studentsMoreThanClassAverage);
        return categorizedStudents;
    }

    public static ArrayList<Student> getStudentHeighstScoringStats(ArrayList<Student> students) {
        Student heighstStudentforICT01 = students.get(0);
        Student heighstStudentforICT02 = students.get(0);
        Student heighstStudentforGroupCW1 = students.get(0);
        Student heighstStudentforGroupCW2 = students.get(0);
        Student heighestStudentOverall = students.get(0);
        ArrayList<Student> results = new ArrayList<Student>();

        for (int i=1; i < students.size(); i++) {
            if (heighstStudentforICT01.getComponentMarks().get(0) < students.get(i).getComponentMarks().get(0)) {
                heighstStudentforICT01 = students.get(i);
            }
            if (heighstStudentforICT02.getComponentMarks().get(1) < students.get(i).getComponentMarks().get(1)) {
                heighstStudentforICT02 = students.get(i);
            }
            if (heighstStudentforGroupCW1.getComponentMarks().get(2) < students.get(i).getComponentMarks().get(2)) {
                heighstStudentforGroupCW1 = students.get(i);
            }
            if (heighstStudentforGroupCW2.getComponentMarks().get(3) < students.get(i).getComponentMarks().get(3)) {
                heighstStudentforGroupCW2 = students.get(i);
            }
            if (calculateTotalModuleMarks(heighestStudentOverall) < calculateTotalModuleMarks(students.get(i))) {
                heighestStudentOverall = students.get(i);
            }
        }
        results.add(heighstStudentforICT01);
        results.add(heighstStudentforICT02);
        results.add(heighstStudentforGroupCW1);
        results.add(heighstStudentforGroupCW2);
        results.add(heighestStudentOverall);

        return results;
    }

    public static Student getLowestScoringStudent(ArrayList<Student> students) {
        Student lowestStudentOverall = students.get(0);

        for (int i=1; i < students.size(); i++) {
            if (calculateTotalModuleMarks(lowestStudentOverall) > calculateTotalModuleMarks(students.get(i))) {
                lowestStudentOverall = students.get(i);
            }
        }

        return lowestStudentOverall;
    }

    public static ArrayList<Student> getRetakeStudentList(ArrayList<Student> students, int retakeBenchmark) {
        ArrayList<Student> retakeStudents = new ArrayList<Student>();

        for (int i=0; i < students.size(); i++) {
            if (calculateTotalModuleMarks(students.get(i)) < retakeBenchmark) {
                retakeStudents.add(students.get(i));
            }
        }

        return retakeStudents;
    }

    public static ArrayList<ArrayList<Student>> getResitStudentList(ArrayList<Student> students, int resitBenchmark) {
        ArrayList<ArrayList<Student>> resitStudents = new ArrayList<ArrayList<Student>>();
        ArrayList<Student> resitICT = new ArrayList<Student>();
        ArrayList<Student> resitGroupCW1 = new ArrayList<Student>();
        ArrayList<Student> resitGroupCW2 = new ArrayList<Student>();
        for (int i=0; i < students.size(); i++) {
            // check whether the student is a non-retake student
            if (calculateTotalModuleMarks(students.get(i)) >= 40) {
                // Evaluating resit condition
                if ((students.get(i).getComponentMarks().get(0) +  students.get(i).getComponentMarks().get(1))/2 < resitBenchmark) {
                    resitICT.add(students.get(i));
                }
                if (students.get(i).getComponentMarks().get(2) < resitBenchmark) {
                    resitGroupCW1.add(students.get(i));
                }
                if (students.get(i).getComponentMarks().get(3) < resitBenchmark) {
                    resitGroupCW2.add(students.get(i));
                }
            }
        }

        resitStudents.add(resitICT);
        resitStudents.add(resitGroupCW1);
        resitStudents.add(resitGroupCW2);

        return resitStudents;
    }

    public static ArrayList<Integer> getGraphicalDisplayStats(ArrayList<Student> students) {
        ArrayList<Integer> graphicalStats = new ArrayList<Integer>();
        int lessThan30 = 0;
        int between30to39 = 0; //including 30 and 39
        int between40to69 = 0; //including 40 and 69
        int between70to100 = 0; //including 70 and 100
        double tempTotalModuleMark;

        for (int i=0; i < students.size(); i++) {
            tempTotalModuleMark = calculateTotalModuleMarks(students.get(i));
            if (tempTotalModuleMark < 30) {
                lessThan30++;
            } else if (tempTotalModuleMark >= 30 && tempTotalModuleMark <= 39) {
                between30to39++;
            } else if (tempTotalModuleMark >= 40 && tempTotalModuleMark <= 69) {
                between40to69++;
            } else {
                between70to100++;
            }
        }

        graphicalStats.add(lessThan30);
        graphicalStats.add(between30to39);
        graphicalStats.add(between40to69);
        graphicalStats.add(between70to100);

        return graphicalStats;
    }

    public static double calculateTotalModuleMarks(Student student) {
        double tempTotal;
        tempTotal = student.getComponentMarks().get(0)*0.20
                + student.getComponentMarks().get(1)*0.20
                + student.getComponentMarks().get(2)*0.30
                + student.getComponentMarks().get(3)*0.30;
        return tempTotal;
    }

}
