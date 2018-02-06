package ua.org.oa.sergey_kost.practices.practice6;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CurrentThread extends Thread{

    private String message;
    private int delay;
    private int i = 0;

    CurrentThread(String message, int delay){
        this.message = message;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println(currentThread().getName() + " say: \' " + message + "\' - " + i + " time");
            try {
                sleep(delay);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
}
