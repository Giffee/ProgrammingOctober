package ua.org.oa.sergey_kost.practices.practice6;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread().getName() + " " + (i + 1) + "-ый раз");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
                return;
            }

        }
    }
}