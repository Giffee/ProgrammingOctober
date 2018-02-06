package ua.org.oa.sergey_kost.practices.practice1;

import java.util.ArrayList;
import java.util.List;

public class ArraySum {
    public ArrayList<Integer> list = new ArrayList<>();

    public ArraySum(ArrayList<Integer> list) {
        this.list = list;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += this.list.get(i);
        }
        return sum;
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
