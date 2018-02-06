package ua.org.oa.sergey_kost.lectures.lecture4.part3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Iterator;

class MyDequeImpl<E> implements MyDeque<E> {
    private Node<E>[] array;
    private int nextIndex;
    private int length;
    private Node<E> firstNode;
    private Node<E> lastNode;
    public MyDequeImpl() {
        initialization();
    }
    private void initialization() {
        this.array = new Node[2];
        this.nextIndex = 0;
        this.length = 0;
        this.firstNode = null;
        this.lastNode = null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (E e : (E[]) toArray()) {
            sb.append(e);
            sb.append(", ");
        }
        if (!sb.toString().equals("{"))
            sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }
    @Override
    public void addFirst(E e) {
        if (array.length == nextIndex)
            enlarge();
        array[nextIndex] = new Node<>(e, null, null);
        if (firstNode != null) {
            array[nextIndex].setNext(firstNode);
            firstNode.setPrev(array[nextIndex]);
        } else if (lastNode != null) {
            array[nextIndex].setNext(lastNode);
            lastNode.setPrev(array[nextIndex]);
        }
        firstNode = array[nextIndex++];
        if (lastNode == null)
            lastNode = firstNode;
        length++;
    }
    @Override
    public void addLast(E e) {
        if (array.length == nextIndex)
            enlarge();
        array[nextIndex] = new Node<>(e, null, null);
        if (lastNode != null) {
            array[nextIndex].setPrev(lastNode);
            lastNode.setNext(array[nextIndex]);
        } else if (firstNode != null) {
            array[nextIndex].setPrev(firstNode);
            firstNode.setNext(array[nextIndex]);
        }
        lastNode = array[nextIndex++];
        if (firstNode == null)
            firstNode = lastNode;
        length++;
    }
    @Override
    public E removeFirst() {
        Node<E> result = firstNode;
        firstNode = firstNode.getNext();
        firstNode.setPrev(null);
        removeInArray(result);
        return result.getElement();
    }
    @Override
    public E removeLast() {
        Node<E> result = lastNode;
        lastNode = lastNode.getPrev();
        lastNode.setNext(null);
        removeInArray(result);
        return result.getElement();
    }
    @Override
    public E getFirst() {
        return firstNode.getElement();
    }
    @Override
    public E getLast() {
        return lastNode.getElement();
    }
    @Override
    public boolean contains(Object o) {
        for (Object o1 : toArray())
            if (o.equals(o1))
                return true;
        return false;
    }
    @Override
    public void clear() {
        initialization();
    }
    @Override
    public Object[] toArray() {
        Object[] result = new Object[length];
        if (firstNode != null) {
            Node<E> node = firstNode;
            result[0] = firstNode.getElement();
            for (int i = 1; (node = node.getNext()) != null; i++)
                result[i] = node.getElement();
        }
        return result;
    }
    @Override
    public int size() {
        return length;
    }
    @Override
    public boolean containsAll(MyDeque<? extends E> deque) {
        for (Object o : deque.toArray())
            if (!contains(o))
                return false;
        return true;
    }
    private void enlarge() {
        int newLength = length * 2;
        Node<E>[] newArray = new Node[newLength];
        int used = 0;
        for (int i = 0; i < nextIndex; i++)
            if (array[i] != null)
                newArray[used++] = array[i];
        array = newArray;
        nextIndex = used;
    }
    private void removeInArray(Node<E> e) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == e) {
                array[i] = null;
                length--;
                break;
            }
    }
    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }
    @Override
    public ListIterator<E> listIterator() {
        return new ListIteratorImpl();
    }
    @Getter
    @Setter
    @ToString
    private static class Node<E> {
        // хранимый элемент
        private E element;
        // ссылка на следующий элемент списка
        private Node<E> next;
        // ссылка на предыдущий элемент списка
        private Node<E> prev;
        private Node(E element, Node<E> next, Node<E> prev) {
            setElement(element);
            setNext(next);
            setPrev(prev);
        }
    }
    private class IteratorImpl implements Iterator<E> {
        protected boolean isNext = false;
        protected Node<E> node;
        @Override
        public boolean hasNext() {
            return ((node == null) ? firstNode : node.getNext()) != null;
        }
        @Override
        public E next() {
            isNext = true;
            return ((node == null) ? (node = firstNode) : (node = node.getNext())).getElement();
        }
        @Override
        public void remove() {
            if (isNext) {
                node = NodeAfterRemove();
                isNext = false;
            } else {
                throw new IllegalStateException();
            }
        }
        protected Node<E> NodeAfterRemove() {
            if (node == firstNode)
                firstNode = node.getNext();
            if (node == lastNode)
                lastNode = node.getPrev();
            Node<E> prevNode = node.getPrev();
            Node<E> nextNode = node.getNext();
            if (prevNode != null)
                prevNode.setNext(nextNode);
            if (nextNode != null)
                nextNode.setPrev(prevNode);
            removeInArray(node);
            return prevNode;
        }
    }
    private class ListIteratorImpl extends IteratorImpl implements ListIterator<E> {
        private boolean isPrev = false;
        @Override
        public boolean hasPrevious() {
            return node != null && node.getPrev() != null;
        }
        @Override
        public E previous() {
            isPrev = true;
            return (node = node.getPrev()).getElement();
        }
        @Override
        public void set(E e) {
            node.setElement(e);
        }
        @Override
        public void remove() {
            if (isNext||isPrev) {
                node = NodeAfterRemove();
                isNext = false;
                isPrev = false;
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
