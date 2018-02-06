package ua.org.oa.sergey_kost.lectures.lecture3;

import lombok.ToString;

@ToString
public class GenericStorage<T> {

    public static final String INDEX_ERROR = "Wrong index";
    private int size;
    private Object[] mas;

    GenericStorage() {
        this.mas = new Object[10];
    }

    GenericStorage(int size) {
        this.mas = new Object[size];
    }

    public void add(T o) {
        if (size < mas.length && o != null) {
            mas[size++] = o;
            System.out.println("Object \"" + o + "\" was added");
        } else if (o == null) {
            System.out.println("Can't add null element");
        } else {
            System.out.println("Array is full");
        }
    }

    public T get(int index) {
        T result = null;
        if (index >= 0 && index < size) {
            result = (T) mas[index];
        } else {
            System.out.println(INDEX_ERROR);
        }
        return result;
    }

    public T[] getAll() {
        return (T[]) mas;
    }

    public void update(int index, T o) {
        if ((index >= 0 && index < size) && mas[index] != null) {
            mas[index] = o;
        } else {
            System.out.println(INDEX_ERROR);
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                if (i == size - 1) {
                    mas[i] = null;
                    size--;
                    break;
                } else {
                    mas[i] = mas[i + 1];

                }
            }
        } else {
            System.out.println(INDEX_ERROR);
        }
    }

    public void delete(T o) {
        boolean result = false;
        if (o == null) {
            System.out.println("Use not 'null' object");
        } else {
            for (int i = 0; i < mas.length; i++) {
                if (mas[i] == o) {
                    size--;
                    for (int j = i; j < mas.length - 1; j++) {
                        mas[j] = mas[j + 1];
                        result = true;
                    }
                }
            }
            if (!result) {
                System.out.println("Array doesn't have this object");
            }
        }
    }

    public int getSize() {
        return size;
    }

}
