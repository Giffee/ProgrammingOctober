package ua.org.oa.sergey_kost.lectures.lecture7.deadlock;

public class SecondClass {
    public synchronized static void secondMethod() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered in firstMethod");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
        System.out.println(name + " is trying to enter FirstClass.firstMethod()");
        FirstClass.firstMethod();
    }
}
