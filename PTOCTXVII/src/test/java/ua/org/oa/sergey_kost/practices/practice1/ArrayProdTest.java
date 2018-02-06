package ua.org.oa.sergey_kost.practices.practice1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ArrayProdTest {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayProd arrayProd;

    @Before
    public void initArr() {
        for (int i = 2; i < 7; i++) {
            list.add(i);
        }
        arrayProd = new ArrayProd();
        System.out.println("List initialised");
    }

    @After
    public void clearArr() {
        list = null;
        System.out.println("List cleared");
    }

    @Test
    public void prodArr() throws Exception {
        int expected = 720;
        int actual = arrayProd.prodArr(list);
        assertEquals(expected,actual);
    }

    @Test(expected = NullPointerException.class)
    public void emptyArray() {
        arrayProd.prodArr(null);
    }



}