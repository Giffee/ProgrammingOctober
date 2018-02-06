package ua.org.oa.sergey_kost.lectures.lecture2;

public class App {
    public static void main(String[] args) {
        StringUtils su = new StringUtils();
        System.out.println("~~~~~~~~~~~~~~~~~1 task~~~~~~~~~~~~~~~~~");
        System.out.println(su.reverse("Hello World!"));
        System.out.println("~~~~~~~~~~~~~~~~~2 task~~~~~~~~~~~~~~~~~");
        System.out.println(su.isPalindrome("А роза упала на лапу Азора"));
        System.out.println("~~~~~~~~~~~~~~~~~3 task~~~~~~~~~~~~~~~~~");
        System.out.println(su.modifyString("String with some words."));
        System.out.println("~~~~~~~~~~~~~~~~~4 task~~~~~~~~~~~~~~~~~");
        System.out.println(su.changePlaceOfWords("Some difficult to change words String, please make it without me."));
        System.out.println("~~~~~~~~~~~~~~~~~5 task~~~~~~~~~~~~~~~~~");
        System.out.println(su.changeWordsInAllSentences("Первое Второе Третье Четвертое. Первое Второе Третье Четвертое. Первое Второе Третье Четвертое."));
        System.out.println("~~~~~~~~~~~~~~~~~6 task~~~~~~~~~~~~~~~~~");
        System.out.println(su.isChar("acab bacab caca baba"));
        System.out.println("~~~~~~~~~~~~~~~~~7 task~~~~~~~~~~~~~~~~~");
        System.out.println(su.isDateFormat("13.12.2016"));
        System.out.println("~~~~~~~~~~~~~~~~~8 task~~~~~~~~~~~~~~~~~");
        System.out.println(su.findPhoneNumber("Danny Doo, Flat no 502, Big Apartment, Wide Road, " +
                "Near Huge Milestone, Hugo-city 56010, Ph: 9876543210, " +
                        "Email: 1dan_ny@myworld.com. Maggi Myer, Post bag no 52, " +
                        "Big bank post office, Big bank city 56000, ph: 9876501234, " +
                        "Email: m._a2.-g.gi@my_universe.ua.12345"));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~PARCER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(MarkdownParcer.parcer("##Header line\n" +
                "Simple line *with* em\n" +
                "Simple **line** with strong\n" +
                "Line with link [Link to google](https://www.google.com) in center\n" +
                "Line **with** *many* **elements** and link [Link to FB](https://www.facebook.com)"));


    }
}
