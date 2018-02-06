package ua.org.oa.sergey_kost.practices.practice6.findingFiles;

import com.sun.javaws.Main;
import lombok.AllArgsConstructor;

import java.io.*;

@AllArgsConstructor
public class FindFile extends Thread {
    private static final String PATH_TO_LOG = "./src/main/java/ua/org/oa/sergey_kost/practices/practice6/findingFiles/log.txt";
    private String path;
    private String filter;

    @Override
    public void run() {
        findFile(path, filter);
    }

    private void findFile(String path, String filter) {
        File dir = new File(path);
        File[] fileNames = dir.listFiles();
        for (File fileName : fileNames) {
            if (fileName.isFile() && fileName.getName().endsWith(filter)) {
                writeToFile(fileName.getAbsolutePath(), PATH_TO_LOG);
            } else if (fileName.isDirectory()) {
                new Thread(() -> {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                    findFile(fileName.getPath(), filter);
                }).start();

            }
        }
    }

    public void writeToFile(String path, String logPath) {
        File file = new File(path);
        try (FileWriter writer = new FileWriter(logPath, true)) {
            writer.write(file.getPath());
            writer.append("\n");
        } catch (IOException e) {
            e.getMessage();
        }
    }

}

