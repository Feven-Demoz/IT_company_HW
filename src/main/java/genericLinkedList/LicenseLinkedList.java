package genericLinkedList;

import interfaces.IPrintInfo;
import java.util.List;
//import jdk.internal.jimage.ImageReader;
import java.util.*;

public abstract class LicenseLinkedList<T> implements List<T>, IPrintInfo {
    private Node head;
    private int size;

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node currentNode = head;
        while (currentNode != null) {
            if (Objects.equals(currentNode.data, o)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node currentNode = head;
        int index = 0;
        while (currentNode != null) {
            array[index++] = currentNode.data;
            currentNode = currentNode.next;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            // Create a new array with the same component type as the input array
            @SuppressWarnings("unchecked")
            T1[] newArray = (T1[]) Arrays.copyOf(toArray(), size, a.getClass());
            return newArray;
        }
        System.arraycopy(toArray(), 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        Node newNode = new Node(t);
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (Objects.equals(head.data, o)) {
            head = head.next;
            size--;
            return true;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            if (Objects.equals(currNode.data, o)) {
                prevNode.next = currNode.next;
                size--;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        for (T element : c) {
            add(index, element);
            index++;
        }

        return !c.isEmpty();
    }
    //public abstract void listOfInformation();
    @Override
    public void printInformation() {

    }
}












