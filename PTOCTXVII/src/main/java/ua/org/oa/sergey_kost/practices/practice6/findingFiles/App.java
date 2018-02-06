package ua.org.oa.sergey_kost.practices.practice6.findingFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class App {
    public static final String PATH = "./src/main/resources/texts/";
    public static final String FILTER = ".txt";

    public static void main(String[] args) throws IOException {
        Thread thread1 = new FindFile(PATH, FILTER);
        thread1.start();
    }
}
