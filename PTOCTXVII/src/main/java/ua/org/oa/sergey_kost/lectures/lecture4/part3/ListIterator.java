package ua.org.oa.sergey_kost.lectures.lecture4.part3;

import java.util.Iterator;

interface ListIterator<E> extends Iterator<E> {
    boolean hasPrevious();
    E previous();
    void set(E e);
    void remove();
}
