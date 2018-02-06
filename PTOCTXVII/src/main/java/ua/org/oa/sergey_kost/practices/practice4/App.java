package ua.org.oa.sergey_kost.practices.practice4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ua.org.oa.sergey_kost.practices.practice4.TextAnalyzer.sortParameters.*;

public class App {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Aza", "Krek", 3));
        list.add(new Student("Aza", "Bred", 4));
        list.add(new Student("Aza", "Zred", 4));
        list.add(new Student("Ara", "Lopreed", 4));
        list.add(new Student("Aza", "Arnol", 4));

        //Task 2
        System.out.println("~~~~~~~~~~~~~~~~TASK 2~~~~~~~~~~~~~~~~");
        Map<String, Student> map = StudentUtils.createMapFromList(list);
        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        //Task 3
        System.out.println("~~~~~~~~~~~~~~~~TASK 3~~~~~~~~~~~~~~~~");
        StudentUtils.printStudentsSameCourse(list, 4);

        //Task 4
        System.out.println("~~~~~~~~~~~~~~~~TASK 4~~~~~~~~~~~~~~~~");
        System.out.println(StudentUtils.sortStudents(list));

//******************************************************************************//
        final String path = "./src/main/resources/Romeo.txt";
        final String encoding = "UTF-8";

        System.out.println("~~~~~~~~~~~~~~~~TASK 5~~~~~~~~~~~~~~~~");
        String str = TextAnalyzer.readFromFile(path, encoding);
        System.out.println(TextAnalyzer.analyzeText(str));

        System.out.println("~~~~~~~~~~~~~~~~TASK 6~~~~~~~~~~~~~~~~");
//        TextAnalyzer.analyzeText(str, ValueIncrease);
//        TextAnalyzer.analyzeText(str, ValueDecrease);
//        TextAnalyzer.analyzeText(str, KeyIncrease);
        TextAnalyzer.analyzeText(str, ValueDecrease);

    }
}
