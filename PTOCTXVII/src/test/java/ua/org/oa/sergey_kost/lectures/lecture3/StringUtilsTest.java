package ua.org.oa.sergey_kost.lectures.lecture3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.org.oa.sergey_kost.lectures.lecture2.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StringUtilsTest {

    StringUtils su;

    @Before
    public void createObject() {
        su = new StringUtils();
    }

    @After
    public void destroyObject() {
        su = null;
    }

    @Test
    public void reverseResultCheck() throws Exception {
        String s = "Hello World!";
        String actual = su.reverse(s);
        String expected = "!dlroW olleH";
        assertEquals("Check correctly of reverse() result", expected, actual);
    }

    @Test
    public void isPalindrome() throws Exception {
        String s = "А роза упала на лапу Азора";
        boolean actual = su.isPalindrome(s);
        boolean expected = true;
        assertEquals("Check correctly of isPalindrome() result", expected, actual);
    }

    @Test
    public void modifyString() throws Exception {
        String s = "String with some words";
        String actual = su.modifyString(s);
        String expected = "String";
        assertEquals("Check correctly of modifyString() result", expected, actual);
    }

    @Test
    public void changePlaceOfWords() throws Exception {
        String s = "String with some words";
        String actual = su.changePlaceOfWords(s);
        String expected = "words with some String";
        assertEquals("Check correctly of changePlaceOfWords() result", expected, actual);
    }

    @Test
    public void changeWordsInAllSentences() throws Exception {

    }

    @Test
    public void isChar() throws Exception {
        String s = "acababacaba";
        boolean actual = su.isChar(s);
        boolean expected = true;
        assertEquals("Check correctly of isChar() result", expected, actual);
    }

    @Test
    public void isDateFormat() throws Exception {
        String s = "13.12.2016";
        boolean actual = su.isDateFormat(s);
        boolean expected = true;
        assertEquals("Check correctly of isDateFormat() result", expected, actual);
    }

    @Test
    public void findPhoneNumber() throws Exception {
        String s = "Danny Doo, Flat no 502, Big Apartment, Wide Road, " +
                "Near Huge Milestone, Hugo-city 56010, Ph: 9876543210, " +
                "Email: 1dan_ny@myworld.com. Maggi Myer, Post bag no 52, " +
                "Big bank post office, Big bank city 56000, ph: 9876501234, " +
                "Email: m._a2.-g.gi@my_universe.ua.12345";
        List<String> actual = su.findPhoneNumber(s);
        List<String> expected = new ArrayList<>();
        expected.add("+(987)654-32-10");
        expected.add("+(987)650-12-34");
        assertEquals("Check correctly of isDateFormat() result", expected, actual);
    }

}