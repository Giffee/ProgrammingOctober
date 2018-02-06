package ua.org.oa.sergey_kost.lectures.lecture6.fileEditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        String path = "D:\\Films\\11.22.63\\11.22.63 (Season 01) LostFilm";
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Input path to directory, you want to edit: ");
//        path = reader.readLine();

        Editor editor = new Editor();
        editor.showFilesInFolder(path);
        editor.createFile(path);
        editor.deleteFile(path);
        editor.rename(path);
        editor.showFilesInFolder(path);


    }
}
