package ua.org.oa.sergey_kost.practices.practice5;

import ua.org.oa.sergey_kost.practices.practice2.Parser;

import javax.xml.bind.annotation.XmlElementDecl;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentUtil {

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

    public static void findStudent(String str) {
        Map<String, List<Integer>> map = new HashMap<>();
        Pattern pattern = Pattern.compile("(?<name>[\\w]+ [\\w]+) = (?<mark>[\\d{1,2}]+)", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            if (map.containsKey(matcher.group("name"))) {
                map.get(matcher.group("name")).add(Integer.parseInt(matcher.group("mark")));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(matcher.group("mark")));
                map.put(matcher.group("name"), list);
            }
        }
        int averageMark;
        for (Map.Entry<String, List<Integer>> stringListEntry : map.entrySet()) {
            averageMark = 0;
            for (Integer integers : stringListEntry.getValue()) {
                averageMark += integers;
            }
            stringListEntry.getValue().add(0, averageMark / stringListEntry.getValue().size());
        }

        int count = 0;
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            if(entry.getValue().get(0) > 90) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            } else {
                count++;
                if(count==map.size()) {
                    System.out.println("There are no students with average mark more than 90");
                }
            }
        }

    }
}





