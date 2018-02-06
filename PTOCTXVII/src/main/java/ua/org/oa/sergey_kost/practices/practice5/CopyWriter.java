package ua.org.oa.sergey_kost.practices.practice5;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class CopyWriter {
    //Symbol buffered

    public static void copyFileSymbolBuffered(String from, String to) {
        try (BufferedReader br = new BufferedReader(new FileReader(from));
             BufferedWriter bw = new BufferedWriter(new FileWriter(to))) {
            while (br.ready()) {
                bw.write(br.readLine());
                bw.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Byte buffered
    public static void copyFileByteBuffered(String from, String to) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(from));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(to))) {
            byte[] buf = new byte[8];
            int length = 0;
            while ((length = bis.read(buf)) != -1) {
                bos.write(buf, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Symbol unbuffered
    public static void copyFileSymbolUnbuffered(String from, String to) {
        try (FileReader fr = new FileReader(from);
             FileWriter fw = new FileWriter(to)) {
            while (fr.ready()) {
                fw.write(fr.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    //Byte unbuffered
    public static void copyFileByteUnbuffered(String from, String to) {
        try (FileInputStream fis = new FileInputStream(from);
             FileOutputStream fos = new FileOutputStream(to)) {
            byte[] buf = new byte[8];
            int length = 0;
            while ((length = fis.read(buf)) != -1) {
                fos.write(buf, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
