package ua.org.oa.sergey_kost.lectures.lecture4.part3;

import java.util.Arrays;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        MyDeque<Number> deque = new MyDequeImpl<>();
        ListIterator<Number> itList = deque.listIterator();
        while (itList.hasPrevious()) {
            System.out.println(itList.previous());
        }
        while (itList.hasNext()) {
            System.out.println(itList.next());
        }
        while (itList.hasPrevious()) {
            System.out.println(itList.previous());
        }
        deque.addLast(8.88);
        System.out.println("Deque, after deque.addLast(8.88) = " + deque);
        deque.addFirst(433);
        System.out.println("Deque, after deque.addFirst(433) = " + deque);
        System.out.println("deque.contains(433) = " + deque.contains(433));
        System.out.println("deque.size = " + deque.size());
        System.out.println("deque.toArray() = " + Arrays.toString(deque.toArray()));
        System.out.println("deque.getFirst() = " + deque.getFirst());
        System.out.println("deque.getLast() = " + deque.getLast());
        deque.addFirst(55);
        System.out.println("Deque, after deque.addFirst(55) = " + deque);
        deque.addLast(34);
        System.out.println("Deque, after deque.addLast(34) = " + deque);
        System.out.println("deque.removeFirst() = " + deque.removeFirst());
        System.out.println("Deque: " + deque);
        System.out.println("deque.removeLast() = " + deque.removeLast());
        deque.addFirst(55);
        System.out.println("Deque, after deque.addFirst(55) = " + deque);
        deque.addLast(34);
        System.out.println("Deque, after deque.addLast(34) = " + deque);
        System.out.println("Deque: " + deque);
        deque.addFirst(55);
        System.out.println("Deque, after deque.addFirst(55) = " + deque);
        deque.addLast(34);
        System.out.println("Deque, after deque.addLast(34) = " + deque);
        System.out.println("deque.removeFirst() = " + deque.removeFirst());
        System.out.println("Deque: " + deque);
        System.out.println("deque.containsAll(deque) = " + deque.containsAll(deque));
        System.out.println("deque.contains(1) = " + deque.contains(1));
        System.out.println("deque.contains(34) = " + deque.contains(34));
        System.out.print("Iter deque: [");
        for (Number number : deque) {
            System.out.print(number + " ");
        }
        System.out.println("]");
        System.out.print("Remove deque number: [");

        Iterator<Number> it = deque.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
            it.remove();
        }
        System.out.println("]");

        for (Number number : deque) {
            System.out.println("deque  = " + number);
        }
        System.out.println("Deque, after remove(): " + deque);
        deque.addFirst(55);
        deque.addFirst(23);
        deque.addFirst(38);
        System.out.println("Deque, after deque.addFirst(*) *{55,23,38} = " + deque);
        deque.addLast(34);
        deque.addLast(3);
        deque.addLast(-10);
        System.out.println("Deque, after deque.addLast(*) *{34,3,-10} = " + deque);
        it = deque.iterator();
        System.out.print("Deque print by while: [");
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println("]");
        System.out.print("Deque print by lambda: [");
        deque.forEach(a -> System.out.print(a + " "));
        System.out.println("]");
        System.out.print("Deque print, using .hasNext(): [");
        while (itList.hasNext()) {
            System.out.print(itList.next() + " ");
        }
        System.out.println("]");
        System.out.print("Deque print, using .hasPrevious(): [");
        while (itList.hasPrevious()) {
            System.out.print(itList.previous() + " ");
        }
        System.out.println("]");
        System.out.println("deque.size() = " + deque.size());
        deque.clear();
        System.out.println("deque.clear(): ");
        System.out.print("Deque: [");
        deque.forEach(a -> System.out.print(a + " "));
        System.out.println("]");
        System.out.println("deque.size() = " + deque.size());
    }
}
