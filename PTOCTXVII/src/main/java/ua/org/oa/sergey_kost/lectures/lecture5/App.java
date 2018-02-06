package ua.org.oa.sergey_kost.lectures.lecture5;

import java.util.Map;

public class App {
    public static final String PATH = ".\\src\\main\\resources\\file.txt";
    public static Map<String, String> vocabulary;
    public static void main(String[] args) {
        Translator tr = new Translator();
        vocabulary = tr.readVocabulary("toRus.txt");
        tr.translate(PATH,vocabulary);

    }
}
