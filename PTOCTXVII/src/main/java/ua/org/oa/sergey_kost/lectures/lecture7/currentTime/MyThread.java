package ua.org.oa.sergey_kost.lectures.lecture7.currentTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {
    private SimpleDateFormat simpleDateFormat;
    private ThreadGroup threadGroup;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void run() {
        new Thread(() -> {
            threadGroup = currentThread().getThreadGroup();
            try {
                reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            threadGroup.interrupt();
            System.out.println("All threads were stopped!");
        }).start();

        while (true) {
            threadGroup = currentThread().getThreadGroup();
            simpleDateFormat = new SimpleDateFormat("'Current time:\t'HH:mm:ss");
            System.out.println(simpleDateFormat.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }


        }
    }
}
