package ua.org.oa.sergey_kost.practices.practice6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;

public class App {

    public static final String PATH = "./src/main/java/ua/org/oa/sergey_kost/practices/practice6/findingFiles/";

    public static void main(String[] args) throws InterruptedException {

        //***************************TASK 1*****************************
        long start, end;
        Thread thread = new MyThread();
        thread.setName("MyThread");
        start = System.currentTimeMillis();
        thread.start();
        thread.join();
        end = System.currentTimeMillis();
        System.out.println("Прошло " + (end - start) + " миллисекунд");

        Thread runnable = new Thread(new MyRunnable());
        runnable.setName("MyRunnable");
        start = System.currentTimeMillis();
        runnable.start();
        runnable.join();
        end = System.currentTimeMillis();
        System.out.println("Прошло " + (end - start) + " миллисекунд");

        //***************************TASK 2*****************************
        Map<Integer, CurrentThread> map = new HashMap<>();
        map.put(1, new CurrentThread("Hello(5s)", 5000));
        map.put(2, new CurrentThread("My name is Vova(4s)", 4000));
        map.put(3, new CurrentThread("Say goodbye yesterday(0.5s)", 500));
        MyShedule myShedule = new MyShedule();
        myShedule.createGroupOfThreads(map, 9000);

    }
}
