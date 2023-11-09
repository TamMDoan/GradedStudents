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

    public void setExamScore(int examNumber, Double newScore){
        examScores.remove(examScores.get(examNumber-1));
        examScores.add(examNumber - 1, newScore);
    }

    public Double getAverageExamScore(){
        Double sum = 0.0;
        for(Double score : examScores){
            sum += score;
        }
        String str = "hello world!";

        return sum / examScores.size();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: " + this.firstName + " " + this.lastName);
        sb.append("\n> Average Score: " + getAverageExamScore());
        sb.append("\n> Exam Scores:");
        for(int i = 0; i < examScores.size(); i++){
            sb.append("\n   Exam " + (i +1) + " -> " + examScores.get(i).intValue());
        }

        return sb.toString();
    }

}