package ua.org.oa.sergey_kost.lectures.lecture3;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        GenericStorage<String> gs = new GenericStorage<>(20);
        System.out.println("**********ADD**********");
        gs.add("1");
        gs.add("2");
        gs.add("3");
        gs.add("4");
        gs.add("5");
        gs.add("6");
        gs.add("7");
        gs.add("8");
        gs.add("9");
        gs.add("11");
        gs.add("12");
        gs.add("13");
        gs.add("14");
        gs.add("15");
        gs.add("16");
        gs.add("17");
        gs.add("18");
        gs.add("19");

        System.out.println("**********GET**********");
        System.out.println(gs.get(1));

        System.out.println("**********GET ALL**********");
        System.out.println(Arrays.toString(gs.getAll()));

        System.out.println("**********UPDATE**********");
        gs.update(3, "10");
        System.out.println(Arrays.toString(gs.getAll()));

        System.out.println("**********DELETE**********");
        gs.delete(7);
        gs.delete(2);
        gs.delete(3);
        gs.delete(22);
        System.out.println(Arrays.toString(gs.getAll()));

        System.out.println("**********DELETE OBJ**********");
        gs.delete("6");
        gs.delete("17");
        gs.delete("19");
        gs.delete(null);
        gs.delete("number");
        System.out.println(Arrays.toString(gs.getAll()));

        System.out.println("**********GET SIZE**********");
        System.out.println("The size of the filed array is - " + gs.getSize());

    }
}
