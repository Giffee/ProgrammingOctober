package ua.org.oa.sergey_kost.practices.practice6;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.Map;

public class MyShedule extends Thread {

    private ThreadGroup threadGroup;

    public void createGroupOfThreads(Map<Integer, CurrentThread> announcementMap, long timeLimit) {

        int announceIndex = 0;

        for (Map.Entry<Integer, CurrentThread> announce : announcementMap.entrySet()) {
            if (++announceIndex == announce.getKey()) {
                announce.getValue().start();
                threadGroup = currentThread().getThreadGroup();
            }
        }

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " Anonymous class");
            try {
                sleep(timeLimit);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadGroup.interrupt();
            System.out.println("All threads was stopped ");
        }).start();
    }
}


