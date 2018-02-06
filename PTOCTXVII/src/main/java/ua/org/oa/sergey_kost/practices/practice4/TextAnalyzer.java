package ua.org.oa.sergey_kost.practices.practice4;


import java.io.*;
import java.util.*;

import static ua.org.oa.sergey_kost.practices.practice4.TextAnalyzer.sortParameters.*;


public class TextAnalyzer {

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

    public static Map<String, Integer> analyzeText(String str) {
        String[] mas = str.split("[,.:; \n]+");
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String m : mas) {
            if (map.containsKey(m)) {
                map.put(m, map.get(m) + 1);
            } else {
                map.put(m, 1);
            }
        }
        return map;
    }

    public static Map<String, Integer> analyzeText(String str, sortParameters order) {
        Map<String, Integer> map = analyzeText(str);
        switch (order) {
            case ValueIncrease:
            case ValueDecrease:
                map = sortMapByValue(map, order);
                break;
            case KeyIncrease:
            case KeyDecrease:
                map = sortMapByKey(map, order);
                break;
        }
        System.out.println("Map was sorted by " + (order.name().contains("Value") ? "value" : "key") +
                " in " + (order.name().contains("Increase") ? "increasing" : "decreasing") + " order");
        map.forEach((k, v) -> System.out.println(k + "->" + v));
        return map;
    }

    public static Map<String, Integer> sortMapByValue(Map<String, Integer> map, sortParameters parameter) {
        final Map<String, Integer> sortedMap = new TreeMap<>((s1, s2) -> {
            int result;
            if (parameter == ValueIncrease) {
                result = map.get(s1).compareTo(map.get(s2));
            } else {
                result = map.get(s2).compareTo(map.get(s1));
            }
            return result == 0 ? -1 : result;
        });
        sortedMap.putAll(map);
        return sortedMap;
    }

    public static Map<String, Integer> sortMapByKey(Map<String, Integer> map, sortParameters parameter) {
        Map<String, Integer> treeMap;
        if (parameter == KeyIncrease) {
            treeMap = new TreeMap<>();
        } else {
            treeMap = new TreeMap<>(Collections.reverseOrder());
        }
        treeMap.putAll(map);
        return treeMap;
    }

    public enum sortParameters {
        ValueDecrease, ValueIncrease, KeyIncrease, KeyDecrease
    }
}
