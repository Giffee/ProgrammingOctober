package ua.org.oa.sergey_kost.practices.practice5.serialization;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static final String FILE_PATH = "./src/main/resources/";

    public static void main(String[] args) {
        //*************************TASK 6*************************
        List<Student> list = new ArrayList<>();
        list.add(new Student("Misha", 3));
        list.add(new Student("Vasya", 3));
        list.add(new Student("Kolya", 4));
        list.add(new Student("Sasha", 2));
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("Petya", 4));
        list2.add(new Student("Ivan", 4));

        Group.serializeObjects(FILE_PATH + "group", new Group("PTaug-XVII", list),
                new Group("23b", list2));
        Group.deserializeObjects(FILE_PATH + "group").forEach(System.out::println);
    }
}
