package ua.org.oa.sergey_kost.practices.practice5.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Group implements Serializable{
    public static final String PATH = "./src/main/resources/";

    private String name;
    private List<Student> list;

    public static <T extends Serializable> void serializeObjects(String path, T... objects) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            for (T obj : objects) {
                oos.writeObject(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends Serializable> List<T> deserializeObjects(String path) {
        List<T> tList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            while (true) {
                tList.add((T) ois.readObject());
            }
        } catch (EOFException e) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tList;
    }
}
