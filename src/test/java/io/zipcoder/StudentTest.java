package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testStudentConstructor(){
        String firstName = "Tam";
        String lastName = "Doan";
        Double[] testScores = new Double[]{10.0, 12.0, 20.0};

        Student student = new Student(firstName, lastName, testScores);

        Assert.assertNotNull(student);
    }

    @Test
    public void testSetFirstName(){
        String firstName = "Tam";
        String lastName = "Doan";
        Double[] testScores = new Double[]{10.0, 12.0, 20.0};

        Student student = new Student(firstName, lastName, testScores);
        String expected = "Maria";
        student.setFirstName(expected);

        Assert.assertEquals(expected, student.getFirstName());
    }

    @Test
    public void testSetLastName(){
        String firstName = "Tam";
        String lastName = "Doan";
        Double[] testScores = new Double[]{10.0, 12.0, 20.0};

        Student student = new Student(firstName, lastName, testScores);
        String expected = "Haha";
        student.setLastName(expected);

        Assert.assertEquals(expected, student.getLastName());
    }

    @Test
    public void testGetNumberOfExams(){
        String firstName = "Tam";
        String lastName = "Doan";
        Double[] testScores = new Double[]{10.0, 12.0, 20.0};

        Student student = new Student(firstName, lastName, testScores);
        int expected = testScores.length;
        student.getNumberOfExamsTaken();

        Assert.assertEquals(expected, student.getNumberOfExamsTaken());
    }

    @Test
    public void testGetExamScores(){
        String firstName = "Tam";
        String lastName = "Doan";
        Double[] testScores = new Double[]{10.0, 12.0, 20.0};

        Student student = new Student(firstName, lastName, testScores);
        String expected = "Exam 1 -> 10\nExam 2 -> 12\nExam 3 -> 20\n";

        Assert.assertEquals(expected, student.getExamScores());

    }

    @Test
    public void testAddExamScore(){
        String firstName = "Tam";
        String lastName = "Doan";
        Double[] testScores = new Double[]{10.0, 12.0, 20.0};

        Student student = new Student(firstName, lastName, testScores);
        student.addExamScore(30.0);
        String expected = "Exam 1 -> 10\nExam 2 -> 12\nExam 3 -> 20\nExam 4 -> 30\n";

        Assert.assertEquals(expected, student.getExamScores());
    }

    @Test
    public void testSetExamScore(){
        String firstName = "Tam";
        String lastName = "Doan";
        Double[] testScores = new Double[]{10.0, 12.0, 20.0};

        Student student = new Student(firstName, lastName, testScores);

    }

}