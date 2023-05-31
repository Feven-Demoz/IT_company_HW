package genericLinkedList;
import interfaces.IPrintInfo;
import java.util.List;
//import jdk.internal.jimage.ImageReader;
import java.util.*;
import java.util.function.UnaryOperator;

import org.apache.log4j.Logger;
public class LicenseLinkedList<T> implements List<T>, IPrintInfo {
    public static Logger logger = Logger.getLogger(LicenseLinkedList.class);
    private Node<T> head;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;

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
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    @Override
    public boolean add(T t) {
        if (head == null) {
            head = new Node<T>(t);
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<T>(t);

    size++;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        } else {
            Node<T> current = head;
            if (current.data.equals(o)) {
                if (current == head) {
                    head = current.next;
                } else {
                }
                while (current.next != null) {
                    current = current.next;
                }
            }
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
        Objects.requireNonNull(c, "Collection can't be null");

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        boolean modified = false;

        for (T element : c) {
            add(index++, element);
            modified = true;
        }

        return modified;
    }



    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("method not used");
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }


    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> node = getNode(index);
        return node.data;
    }


    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> node = getNode(index);
        T oldValue = node.data;
        node.data = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> prevNode = getNode(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }

        size++;


    }

    @Override
    public T remove(int index) {
        if(index < 0 || index>= size){
            throw new IndexOutOfBoundsException();
        }
        T removedElement;
        if(index==0){
            removedElement = head.data;
            head= head.next;
        }else {
            Node<T>previous = null;
            Node<T>current = head;
            for(int i= 0; i< index; i++){
                previous=current;
                current= current.next;
            }
            removedElement = current.data;
            previous.next = current.next;
        }
        size--;
        return removedElement;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

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
        };
    }

   @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("method not used");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("method not used");
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("method not used");
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("method not used");
    }



    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("method not used");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("method not used");
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("method not used");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("method not used");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("method not used");
    }



    @Override
    public void printInformation() {
        Node<T> current = head;
        while (current != null) {
           logger.info(current.data);
            current = current.next;
        }
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}





