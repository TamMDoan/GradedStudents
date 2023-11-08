package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores(){
        StringBuilder sb = new StringBuilder();
        for(Double score : examScores){
            sb.append("Exam " + (examScores.indexOf(score)+1) + " -> " + score.intValue() + "\n");
        }

        return sb.toString();
    }

    public void addExamScore(Double score){
        this.examScores.add(score);
    }

}