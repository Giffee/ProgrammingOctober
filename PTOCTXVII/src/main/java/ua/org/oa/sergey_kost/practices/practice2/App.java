package ua.org.oa.sergey_kost.practices.practice2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        String strBaby = Parser.readFromFile("D://practice2/baby2008.html", "utf-8");
        List<Rating> ratingList = new ArrayList<>();
        Pattern pattern = Pattern.compile("<td>(?<rate>\\d+)<\\/td><td>(?<male>\\w\\D{2,15})<\\/td><td>(?<female>\\w\\D{2,15})<\\/td>");
        Matcher matcher = pattern.matcher(strBaby);
        while (matcher.find()) {
            ratingList.add(new Rating(Integer.parseInt(matcher.group("rate")), matcher.group("male"), matcher.group("female")));
        }
        System.out.println(ratingList);

        String strNotebook = Parser.readFromFile("D://practice2/source.html", "windows-1251");
        List<Notebook> notebookList = new ArrayList<>();
        pattern = Pattern.compile("rel=\"lightbox\" title=\"(?<name>.+)\"[\\s\\S]+?<p class=\"description\">(?<description>[\\S\\s]+?)<br/>[\\s\\S]+?class=\"price cost\">(?<price>.+)</span>");
        matcher = pattern.matcher(strNotebook);
        while(matcher.find()) {
            notebookList.add(new Notebook(matcher.group("name"),matcher.group("description"),(matcher.group("price"))));
        }
        System.out.println(notebookList);

    }



}
