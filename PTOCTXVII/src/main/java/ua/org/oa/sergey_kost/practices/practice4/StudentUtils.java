package ua.org.oa.sergey_kost.practices.practice4;

import java.util.*;

public class StudentUtils {


    public static Map<String, Student> createMapFromList(List<Student> students) {
        int i = 0;
        Map<String, Student> map = new HashMap<>();

        for (Student student : students) {
            map.put(student.getFirstName() + " " + student.getLastName(), student);
        }
        return map;
    }

    public static void printStudentsSameCourse(List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        }
    }

    public static List<Student> sortStudents(List<Student> student) {
        Collections.sort(student, (s1, s2) -> {
            if (s1.getFirstName().compareTo(s2.getFirstName()) == 0) {
                return s1.getLastName().compareTo(s2.getLastName());
            } else
                return s1.getFirstName().compareTo(s2.getFirstName());
        });
        return student;
    }
}
