package ua.org.oa.sergey_kost.lectures.lecture2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str.replaceAll(" ", "").toLowerCase()).reverse();
        return sb.toString().equals(str.replaceAll(" ", "").toLowerCase());
    }

    public String modifyString(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (sb.length() > 10) {
            sb.delete(6, sb.length());
        } else {
            for (int i = sb.length(); i < 12; i++) {
                sb.append('o');
            }
        }
        return sb.toString();
    }

    public String changePlaceOfWords(String str) {
        String[] words = str.split(" ");
        StringBuilder change = new StringBuilder();

        change = change.append(words[words.length - 1]).append(" ");

        for (int i = 1; i < words.length - 1; i++) {
            change = change.append(words[i]).append(" ");
        }
        change.append(words[0]);

        return change.toString();
    }

    public String changeWordsInAllSentences(String str) {
        String[] sentence = str.concat(" ").split("\\. ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sentence.length; i++) {
            sb.append(changePlaceOfWords(sentence[i]) + ". ");
        }

        return sb.toString();
    }

    public boolean isChar(String str) {
        boolean bool;
        if (Pattern.matches("\\A[abc]+\\Z", str)) {
            bool = true;
        } else
            bool = false;
        return bool;
    }

    public boolean isDateFormat(String str) {
        boolean bool = false;
        Pattern pattern = Pattern.compile("\\A(\\d{2})\\.(\\d{2})\\.(\\d{4})\\Z");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            int dd = Integer.parseInt(matcher.group(1));
            int mm = Integer.parseInt(matcher.group(2));
            int yyyy = Integer.parseInt(matcher.group(3));
            if ((dd > 0 && dd <= 31) && (mm > 0 && mm <= 12) && (yyyy > 1 && yyyy <= 2017)) {
                if (Pattern.matches("\\A(?<MM>\\d{2})\\.(\\d{2})\\.(\\d{4})\\Z", str)) {
                    bool = true;
                }
            } else {
                System.out.println("Wrong date!");
            }
        }
        return bool;
    }

    public List<String> findPhoneNumber(String str) {
        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d{3})(\\d{3})(\\d{2})(\\d{2})");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            stringList.add("+("+(matcher.group(1)+")" + matcher.group(2) + "-" + matcher.group(3) + "-" + matcher.group(4)));
        }
        return stringList;
    }

}
