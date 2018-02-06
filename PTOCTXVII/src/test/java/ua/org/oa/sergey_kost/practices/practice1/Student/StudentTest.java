package ua.org.oa.sergey_kost.practices.practice1.Student;

import org.junit.*;

public class StudentTest {

    static Student student;

    @BeforeClass
    public static void before() throws Exception {
        student = new Student("Andrey Barovskiy", "KIT-13a", 2);
        student.addMark("Programming", 1, 1, 3);
        student.addMark("Programming", 1, 2, 4);
        student.addMark("Programming", 2, 1, 5);
        student.addMark("English", 1, 1, 3);
    }

    @AfterClass
    public static void after() throws Exception {
        student = null;
        System.out.println("Tests was finished.");
    }

    @Test
    public void addMark() throws Exception {
        String actual = student.addMark("English", 2, 1, 4).toString();
        String expected = new Exam("English", 4, 2,1).toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeMark() throws Exception {
        String actual = student.removeMark("English", 1, 1).toString();
        String expected = new Exam("English", 0, 1,1).toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMaxSubjectMark() throws Exception {
        int actual = student.getMaxSubjectMark("Programming");
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsWithSetMark() throws Exception {
        int actual = student.getNumberOfExamsWithSetMark(5);
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageScore() throws Exception {
        double actual = student.getAverageScore(1,2);
        double expected = 4.0;
        Assert.assertEquals(expected, actual, 0.01);
    }

}