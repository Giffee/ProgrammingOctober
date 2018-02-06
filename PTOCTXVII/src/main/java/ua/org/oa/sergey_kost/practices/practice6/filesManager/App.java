package ua.org.oa.sergey_kost.practices.practice6.filesManager;

public class App {
    public static void main(String[] args) {
        CopyFiles copier = new CopyFiles();

        copier.copyThrowThreads("D:\\Films\\11.22.63",
                "D:\\Films\\copied");
    }
}
