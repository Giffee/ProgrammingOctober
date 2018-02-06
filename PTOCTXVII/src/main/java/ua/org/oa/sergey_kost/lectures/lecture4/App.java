package ua.org.oa.sergey_kost.lectures.lecture4;

import java.util.Arrays;

public class App {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        Computer[] mas = new Computer[SIZE];
        for (int i = 0; i < SIZE; i++) {
            mas[i] = new Computer("i-" + i, i*20);
        }

        System.out.println(Computer.findMax(mas));
        System.out.println(Arrays.toString(mas));


    }
}
