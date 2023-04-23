package linkedlist.src.main.java.ua.hillel;

import common.src.main.java.ua.hillel.List;

import java.util.NoSuchElementException;

/**
 * Implement doubly linked list that is based on {@link Node<T>} class (you should implement it as well).
 * This is a simplified version of {@link java.util.LinkedList}.
 */
public class LinkedList<T> implements List<T> {

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    @Override
    public void add(T element) {
        linkLast(element);
    }

    @Override
    public void add(int index, T element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    @Override
    public T get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public T get(T element) {
        int index = 0;
        if (element == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return item;
                index++;
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (element.equals(x.item))
                    return item;
                index++;
            }
        }
        return null;
    }

    @Override
    public T getFirst() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    @Override
    public T getLast() {
        final Node<T> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    @Override
    public void set(int index, T element) {
        checkElementIndex(index);
        Node<T> x = node(index);
        T oldVal = x.item;
        x.item = element;
    }

    @Override
    public boolean remove(int index) {
        if (index > size) {
            return false;
        } else {
            unlink(node(index));
            return true;
        }
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return (first == null) ? true : false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(Node<T> prev, T item, Node<T> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    '}';
        }
    }

    private void linkLast(T t) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, t, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    void linkBefore(T t, Node<T> succ) {
        final Node<T> pred = succ.prev;
        final Node<T> newNode = new Node<>(pred, t, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    T unlink(Node<T> x) {
        final T element = x.item;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }
}
