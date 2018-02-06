package ua.org.oa.sergey_kost.lectures.lecture1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Auto {
    private String mark;
    private int weight;
    private int maxSpeed;
    private boolean transmission; //true - auto, false - manual
    private double price;

    public boolean getTransmission() {
        return transmission;
    }

}
