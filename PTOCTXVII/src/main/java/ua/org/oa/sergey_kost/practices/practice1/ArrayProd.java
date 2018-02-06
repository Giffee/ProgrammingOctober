package ua.org.oa.sergey_kost.practices.practice1;

import java.util.ArrayList;

public class ArrayProd {

    public int prodArr(ArrayList<Integer> list) {
        int sum = 1;
        for (int i = 0; i < list.size(); i++) {
            sum *= list.get(i);
        }
        return sum;
    }
}
