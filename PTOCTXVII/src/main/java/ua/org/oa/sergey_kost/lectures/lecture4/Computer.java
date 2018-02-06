package ua.org.oa.sergey_kost.lectures.lecture4;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Computer implements Comparable {
    private String cpu;
    private int price;

    @Override
    public int compareTo(Object o) {
        Computer c = (Computer) o;
        return Integer.compare(this.price, c.price);
    }

    public static Computer findMax(Computer[] c) {
        Computer compMaxPrice = c[0];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (c[i].compareTo(compMaxPrice) == 1) {
                    compMaxPrice = c[i];
                }
            }
        }
        return compMaxPrice;
    }
}
