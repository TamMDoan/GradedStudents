package io.zipcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Classroom {
    int maxNumberOfStudents;
    Student[] students;
    public Classroom(){
        students = new Student[30];
    }

    public Classroom(int maxNumberOfStudents){
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.students = new Student[maxNumberOfStudents];
    }
    public Classroom(int maxNumberOfStudents, Student[] students){
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.students = students;

    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public double getAverageExamScore(){
        double totalStudentScores = 0.0;
        for(Student student : students){
            totalStudentScores += student.getAverageExamScore();
        }

        return totalStudentScores / students.length;
    }

    public void addStudent(Student student){
        Student[] studentsNew = new Student[this.students.length + 1];
        System.arraycopy(this.students, 0, studentsNew, 0, this.students.length);
        studentsNew[studentsNew.length -1] = student;

        this.students = studentsNew;

    }

    public void removeStudent(String firstName, String lastName){
        Student[] newStudents = new Student[this.students.length];
        int indexOfStudentToRemove = 32; //using 32 because max students is 30

        for(int i = 0; i < this.students.length; i++){
            if(this.students[i].getFirstName().equals(firstName) && this.students[i].getLastName().equals(lastName)){
                indexOfStudentToRemove = i;
                this.students[i] = null;
                break;
            }
        }

        if(indexOfStudentToRemove == 32){
            System.out.println("Student not found.");
        }
        else {
            System.arraycopy(this.students, 0, newStudents, 0, indexOfStudentToRemove+1);
            System.arraycopy(this.students, indexOfStudentToRemove+1, newStudents, indexOfStudentToRemove, this.students.length-1-indexOfStudentToRemove);
            for(int i = this.students.length-indexOfStudentToRemove+1; i < newStudents.length; i++){
                newStudents[i] = null;
            }
        }

        this.students = newStudents;
    }

    public Map<Character, ArrayList<Student>> getGradeBook(){
        Student highestAverageScoreer = this.students[0];

        // finding highest scoring student
        for(Student student : this.students){
            if(highestAverageScoreer.getAverageExamScore() < student.getAverageExamScore()){
                highestAverageScoreer = student;
            }
        }

        // calculating percentiles using highestScorer's score
        double highestAverage = highestAverageScoreer.getAverageExamScore();
        double fUpperLimit = (highestAverage * 11) / 100;
        double dUpperLimit = (highestAverage * 49) / 100;
        double cUpperLimit = (highestAverage * 70) / 100;
        double bUpperLimit = (highestAverage * 89) / 100;

        // assigning students scores based on percentiles
        Map<Character, ArrayList<Student>> gradeBook = new HashMap<>();
        gradeBook.put('A', new ArrayList<Student>());
        gradeBook.put('B', new ArrayList<Student>());
        gradeBook.put('C', new ArrayList<Student>());
        gradeBook.put('D', new ArrayList<Student>());
        gradeBook.put('F', new ArrayList<Student>());


        for (Student student : this.students) {
            if (student.getAverageExamScore() > bUpperLimit) {
                gradeBook.get('A').add(student);
            } else if (student.getAverageExamScore() < bUpperLimit && student.getAverageExamScore() > cUpperLimit) {
                gradeBook.get('B').add(student);
            } else if (student.getAverageExamScore() < cUpperLimit && student.getAverageExamScore() > dUpperLimit) {
                gradeBook.get('C').add(student);
            } else if (student.getAverageExamScore() < dUpperLimit && student.getAverageExamScore() > fUpperLimit) {
                gradeBook.get('D').add(student);
            } else {
                gradeBook.get('F').add(student);
            }
        }

        return gradeBook;

    }
}
