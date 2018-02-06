package ua.org.oa.sergey_kost.practices.practice1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ArraySumTest {
    ArrayList<Integer> list;
    ArraySum arraySum;

    @Before
    public void initSumArr() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        arraySum = new ArraySum(list);
        System.out.println("List initialised");
    }

    @After
    public void clearArr() {
        list = null;
        System.out.println("List cleared");
    }

    @Test
    public void checkStaticSum() throws Exception {
        int expected = 10;
        int actual = ArraySum.sum(list);
        assertEquals(expected, actual);
    }

    @Test
    public void checkSum() throws Exception {
        int expected = 10;
        int actual = arraySum.sum(list);
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void emptyArray() {
        ArraySum.sum(null);
    }


}