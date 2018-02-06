package ua.org.oa.sergey_kost.lectures.lecture6.book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookStorage {
    private final String PATH_TO_SERIALIZATION;
    private final String PATH_TO_FILE;
    private final String FILE_NAME = "Books.txt";
    public List<Book> list;

    public BookStorage(String PATH_TO_SERIALIZATION, String PATH_TO_FILE) {
        this.PATH_TO_SERIALIZATION = PATH_TO_SERIALIZATION;
        this.PATH_TO_FILE = PATH_TO_FILE;
    }

    public String readFromFile() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(PATH_TO_FILE)))) {
            while (br.ready()) {
                sb.append(br.readLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void writeToFile(Book book) {
        String check;
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((new FileOutputStream(PATH_TO_FILE, true))));
             BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(PATH_TO_FILE)))) {
            while (br.ready()) {
                check = br.readLine();
                if (check.contains(book.getTitle())) {
                    System.out.println("Book \'" + book.getTitle() + "\' is already exist! Add another one!");
                } else {
                    bw.write(":" + book.getTitle() + ":" + book.getAuthor() + ":" + book.getYear());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToList() {
        String str = readFromFile();
        list = new ArrayList<>();
        String[] mas = str.replaceAll("\\n", "").split(":");
        for (int i = 0; i < mas.length; i += 3) {
            list.add(new Book(mas[i], mas[i + 1], Integer.parseInt(mas[i + 2])));
        }
    }

    public void serialization() {
        addToList();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_TO_SERIALIZATION + FILE_NAME))) {
            for (Book book : list) {
                oos.writeObject(book);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> deserialization() {
        List<Book> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream((new FileInputStream(PATH_TO_SERIALIZATION + FILE_NAME)))) {
            while (true) {
                list.add((Book) ois.readObject());
            }
        } catch (EOFException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
