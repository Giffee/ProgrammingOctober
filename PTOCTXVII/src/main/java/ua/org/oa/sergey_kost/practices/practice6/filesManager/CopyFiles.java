package ua.org.oa.sergey_kost.practices.practice6.filesManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;

public class CopyFiles extends Thread {

    public void copyThrowThreads(String source, String dest) {
        File dir = new File(source);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Files.copy(file.toPath(), new File(dest + File.separator + file.getName()).toPath());
                    } catch (FileAlreadyExistsException e) {
                        System.out.println(file.getName() + " is already exist!");
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (file.isDirectory()) {
                    File newFile = new File(dest + file.separator + (file.getName()));
                    newFile.mkdirs();
                    new Thread(() -> {
                        try {
                            sleep(200);
                        } catch (InterruptedException e) {
                            e.getMessage();
                        }
                        copyThrowThreads(file.getPath(), newFile.getPath());
                    }).start();
                }
            }
        }
    }

}
