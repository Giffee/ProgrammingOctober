package ua.org.oa.sergey_kost.practices.practice5;

import java.io.*;
import java.util.*;

public class IOStreamUtils {

    public static void writeToFile(String path, String str) {
        try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path), "UTF-8")) {
            out.write(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                sb.append(br.readLine());
            }

        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return sb.toString();
    }

    public static String makeRandomNumbers(int countOfNumbers, int max, int min) {
        String str = "";
        if (countOfNumbers > 0) {
            for (int i = 0; i < countOfNumbers; i++) {
                str += (int) (Math.random() * (max + Math.abs(min) + 1)) + min + " ";
            }
        } else {
            str = null;
        }
        return str;
    }

    public static String sortNumbers(String str) {
        String[] mas = str.split(" ");
        Set<Integer> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < mas.length; i++) {
            set.add(Integer.parseInt(mas[i]));
        }
        set.forEach(a-> sb.append(a).append(" "));
        return sb.toString();
    }
}




