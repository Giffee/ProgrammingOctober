package ua.org.oa.sergey_kost.practices.practice5;

import ua.org.oa.sergey_kost.practices.practice5.serialization.Group;
import ua.org.oa.sergey_kost.practices.practice5.serialization.Student;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static final String FILE_PATH = "./src/main/resources/";
    public static final String ENCODING = "utf-8";

    public static void main(String[] args) {

//        //*****************Task 1-2***************************//
        String numbers = IOStreamUtils.makeRandomNumbers(9, 100, -20);
        IOStreamUtils.writeToFile(FILE_PATH + "file.txt", numbers);
        String readFromFile = IOStreamUtils.readFromFile(FILE_PATH + "file.txt");
        String sortedStr = IOStreamUtils.sortNumbers(readFromFile);
        IOStreamUtils.writeToFile(FILE_PATH + "fileSorted.txt", sortedStr);
//
//        //***********************Task 3***********************//
        String students = StudentUtil.readFromFile(FILE_PATH + "students");
        StudentUtil.findStudent(students);
//
//        //***********************Task 4***********************//
        String str = ChangePlaceOfWords.readFromFile(FILE_PATH + "text.txt");
        System.out.println("Replaced first and last word in each string:\n"
                + ChangePlaceOfWords.changePlaceOfWords(str));
        System.out.println("Replaced first and last word in each sentence:\n"
                + ChangePlaceOfWords.changeWordsInAllSentences(str));

        //***********************Task 5***********************//
        long start, finish;
        start = System.nanoTime();
        CopyWriter.copyFileSymbolBuffered(FILE_PATH + "Romeo.txt", FILE_PATH + "textFile1.txt");
        finish = System.nanoTime();
        System.out.println("Method №1 was worked " + (finish - start) + " nano-seconds");

        start = System.nanoTime();
        CopyWriter.copyFileByteBuffered(FILE_PATH + "Romeo.txt", FILE_PATH + "textFile2.txt");
        finish = System.nanoTime();
        System.out.println("Method №2 was worked " + (finish - start) + " nano-seconds");

        start = System.nanoTime();
        CopyWriter.copyFileSymbolUnbuffered(FILE_PATH + "Romeo.txt", FILE_PATH + "textFile3.txt");
        finish = System.nanoTime();
        System.out.println("Method №3 was worked " + (finish - start) + " nano-seconds");

        start = System.nanoTime();
        CopyWriter.copyFileByteUnbuffered(FILE_PATH + "Romeo.txt", FILE_PATH + "textFile4.txt");
        finish = System.nanoTime();
        System.out.println("Method №4 was worked " + (finish - start) + " nano-seconds");

        //***********************Task 6***********************//


    }
}
