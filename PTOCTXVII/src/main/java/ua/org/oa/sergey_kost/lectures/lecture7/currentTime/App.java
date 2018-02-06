package ua.org.oa.sergey_kost.lectures.lecture7.currentTime;

public class App {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Thread runnable = new Thread(new MyRunnable());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(thread.getName() + " has been finished.");
        }
        System.out.println();
        runnable.start();
        try {
            runnable.join();
        } catch (InterruptedException e) {
            System.out.println(runnable.getName() + " has been finished.");
        }






    }
}
