package ua.org.oa.sergey_kost.lectures.lecture7.deadlock;

public class MyRunnable implements Runnable {

    MyRunnable() {
        FirstClass fc = new FirstClass();
        SecondClass sc = new SecondClass();
        Thread.currentThread().setName("Main Thread");
        Thread thread = new Thread(this, "Second Thread");
        thread.start();
        FirstClass.firstMethod();
    }

    @Override
    public void run() {
        SecondClass.secondMethod();
    }
}
