package ua.org.oa.sergey_kost.practices.practice2;

import java.io.*;

public class Parser {

    public static String readFromFile(String path, String encoding) {
        String str = null;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding))) {
            while ((str = br.readLine()) != null) {
                sb.append(str).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


}
