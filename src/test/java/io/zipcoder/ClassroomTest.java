package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

public class ClassroomTest {

    @Test
    public void testClassroomNullConstructor(){
        Classroom classroom = new Classroom();

        Assert.assertNotNull(classroom);
    }

    @Test
    public void testClassroomConstructor2(){
        int maxNumberOfStudents = 20;
        Classroom classroom = new Classroom(maxNumberOfStudents);

        Assert.assertEquals(maxNumberOfStudents, classroom.getMaxNumberOfStudents());
    }

    @Test
    public void testClassroomConstructor3(){
        int maxNumberOfStudents = 20;
        Student[] students = new Student[maxNumberOfStudents];

        Classroom classroom = new Classroom(maxNumberOfStudents, students);

        Assert.assertEquals(maxNumberOfStudents, classroom.getMaxNumberOfStudents());
        Assert.assertEquals(students, classroom.getStudents());
    }

    @Test
    public void testGetMaxNumberOfStudents(){
        int maxNumberOfStudents = 10;
        Classroom classroom = new Classroom(maxNumberOfStudents);

        int actual = classroom.getMaxNumberOfStudents();

        Assert.assertEquals(maxNumberOfStudents, actual);
    }

    @Test
    public void testGetStudents(){

        int maxNumberOfStudents = 10;
        Student[] students = new Student[]{new Student("Tam", "Doan", new Double[]{12.0})};
        Classroom classroom = new Classroom(maxNumberOfStudents, students);

        Student[] actual = classroom.getStudents();

        Assert.assertEquals(students, actual);
    }

    @Test
    public void testGetAverageExamScore(){
        int maxNumberOfStudents = 20;
        Student[] students = new Student[]{new Student("Tam", "Doan", new Double[]{12.0, 22.0, 13.0})};
        Classroom classroom = new Classroom(maxNumberOfStudents, students);

        double expected = (12.0 + 22.0 + 13.0) / 3;
        double classAverage = classroom.getAverageExamScore();

        Assert.assertEquals(expected, classAverage, 2);

    }

    @Test
    public void testAddStudent(){
        int maxNumberOfStudents = 20;
        Student[] students = new Student[]{new Student("Tam", "Doan", new Double[]{12.0, 22.0, 13.0})};
        Classroom classroom = new Classroom(maxNumberOfStudents, students);

        Student student = new Student("Maria", "Doan", new Double[]{13.0,22.0,50.0});

        classroom.addStudent(student);

        Assert.assertEquals(2, classroom.getStudents().length);

    }

    @Test
    public void testRemoveStudent(){
        int maxNumberOfStudents = 20;
        Student[] students = new Student[]{new Student("Tam", "Doan", new Double[]{12.0, 22.0, 13.0})};
        Classroom classroom = new Classroom(maxNumberOfStudents, students);

        Student student = new Student("Maria", "Doan", new Double[]{13.0,22.0,50.0});
        Student student2 = new Student("ha", "Doan", new Double[]{13.0,22.0,50.0});
        Student student3 = new Student("be", "Doan", new Double[]{13.0,22.0,50.0});
        Student student4 = new Student("sa", "Doan", new Double[]{13.0,22.0,50.0});
        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.addStudent(student4);


        classroom.removeStudent("Tam", "Doan");

        Assert.assertNotNull(classroom.getStudents()[0]);
        Assert.assertNull(classroom.getStudents()[4]);

    }

    @Test
    public void testGetGradeBook(){
        int maxNumberOfStudents = 20;
        Student[] students = new Student[]{new Student("Tam", "Doan", new Double[]{12.0, 22.0, 13.0})};
        Classroom classroom = new Classroom(maxNumberOfStudents, students);

        Student student = new Student("Maria", "Doan", new Double[]{13.0,22.0,50.0});
        Student student2 = new Student("ha", "Doan", new Double[]{34.0,22.0,65.0});
        Student student3 = new Student("be", "Doan", new Double[]{78.0,26.0,26.0});
        Student student4 = new Student("sa", "Doan", new Double[]{95.0,99.0,89.0});
        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.addStudent(student4);

        int expectedA = 1;
        int expectedB = 0;
        int expectedC = 0;
        int expectedD = 4;
        int expectedF = 0;

        Map<Character, ArrayList<Student>> grades = classroom.getGradeBook();

        // assert how many are in each grade, precalculate it beforehand.
        Assert.assertEquals(expectedA, grades.get('A').size());
        Assert.assertEquals(expectedB, grades.get('B').size());
        Assert.assertEquals(expectedC, grades.get('C').size());
        Assert.assertEquals(expectedD, grades.get('D').size());
        Assert.assertEquals(expectedF, grades.get('F').size());


    }

}
