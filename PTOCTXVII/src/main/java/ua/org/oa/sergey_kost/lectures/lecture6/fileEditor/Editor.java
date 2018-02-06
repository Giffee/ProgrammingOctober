package ua.org.oa.sergey_kost.lectures.lecture6.fileEditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Editor {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private File dir;
    private File file;

    public void createFile(String path) throws IOException {
        System.out.println("Input file name:");
        String name = reader.readLine();

        file = new File(path, name);
        try {
            if (file.exists()) {
                System.out.println("File already exist!");
            } else {
                file.createNewFile();
                System.out.println("File \'" + file.getName() + "\' was created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String path) throws IOException {
        System.out.println("Input file name, you want to delete");
        String name = reader.readLine();

        file = new File(path, name);
        if (file.exists()) {
            file.delete();
            System.out.println("File \'" + file.getName() + "\' was deleted");
        } else {
            System.out.println("There is no file with \'" + file.getName() + "\'' name");
        }
    }

    public void rename(String path) throws IOException {
        System.out.println("Input file name, you want to rename");
        String name = reader.readLine();

        file = new File(path, name);
        if (file.exists()) {
            System.out.println("Input new file name");
            String newName = reader.readLine();
            file.renameTo(new File(path, newName));
            System.out.println("File \'" + file.getName() + "\' was renamed to \'" + newName + "\'");
        } else {
            System.out.println("There is no file with \'" + file.getName() + "\' name");
        }
    }

    public void showFilesInFolder(String path) {
        dir = new File(path);
        File[] files = dir.listFiles();
//        System.out.println("List of files in \"" + dir.getPath() + "\" directory:");
        for (File file : files) {
            if (file.isDirectory()) {
                showFilesInFolder(file.getPath());
//                dir = new File(file.getPath());
//                for (int i = 0; i < dir.listFiles().length; i++) {
//                    System.out.println("\tdir#" + dir.getName() + " -> " + dir.listFiles()[i].getName());
//                    showFilesInFolder(dir.getPath());
//                }
            } else {
                System.out.println("\t" + file.getPath());
            }
        }
    }
}
