package ua.org.oa.sergey_kost.lectures.lecture5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {
    public static final String PATH = ".\\src\\main\\resources\\vocabulary\\";
    StringBuilder sb;

    public String readFile(String path) {
        sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"))) {
            while (br.ready()) {
                sb.append(br.readLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("\'" + path.substring(path.lastIndexOf('\\') + 1) + "\' was not found!");
        } catch (IOException e) {
            System.out.println("Problems with file reading!");
        }
        return sb.toString();
    }

    public Map<String, String> readVocabulary(String fileName) {
        boolean bool = false;
        File dir = new File(PATH);
        File[] files = dir.listFiles();

        Map<String, String> vocabulary = new HashMap<>();
        String str = readFile(PATH + fileName);
        Pattern pattern = Pattern.compile("(?<eng>\\b[A-z]*)=(?<rus>[А-я ]*)[,. ]");
        Matcher matcher = pattern.matcher(str);

        for (File file : files) {
            if (file.getName().equals(fileName)) {
                bool = true;
                break;
            }
        }
        if (bool) {
            while (matcher.find()) {
                switch (fileName) {
                    case "toRus.txt":
                        vocabulary.put(matcher.group("eng"), matcher.group("rus"));
                        break;
                    case "toEng.txt":
                        vocabulary.put(matcher.group("rus"), matcher.group("eng"));
                        break;
                }
            }
        } else {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                return null;
            }
        }
        return vocabulary;
    }

    public void translate(String source, Map<String, String> map) {
        if (map != null) {
            System.out.println("********TRANSLATING********");
            String str[] = readFile(source).toLowerCase().replaceAll("[.,-?!:;]", "").split("\\s");
            sb = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                if (map.get(str[i]) != null) {
                    sb.append(map.get(str[i])).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}
