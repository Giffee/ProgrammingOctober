package ua.org.oa.sergey_kost.lectures.lecture7.counterChanging;

public class MyThread extends Thread {
    private Counter c = new Counter();

    @Override
    public void run() {
        while (true) {
//            synchronized (Counter.class) {
                System.out.println(currentThread().getName() + " entered");
                System.out.println("Comparing: " + c.getFirstCounter() + " - " + c.getSecondCounter() + " = " + Integer.compare(c.getFirstCounter(), c.getSecondCounter()));
                c.setFirstCounter(c.getFirstCounter() + 1);
                try {
                    sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                    return;
                }
                c.setSecondCounter(c.getSecondCounter() + 1);
            }
        }
//    }
}
