package ua.org.oa.sergey_kost.lectures.lecture7.deadlock;

public class FirstClass {
    public synchronized static void firstMethod() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered in firstMethod");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
        System.out.println(name + " is trying to enter SecondClass.secondMethod()");
        SecondClass.secondMethod();

    }
}
