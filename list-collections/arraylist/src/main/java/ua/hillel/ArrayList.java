package main.java.ua.hillel;

import main.java.ua.hillel.List;

import java.util.Arrays;
import java.util.Objects;

/**
 * Implement a list that is based on array. This resizable data structure
 * is based on an array and is a simplified version of {@link java.util.ArrayList}.
 */
public class ArrayList<T> implements List<T> {

    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public ArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    @Override
    public void add(T element) {
        add(element, elementData, size);
    }

    @Override
    public void add(int index, T element) {
        rangeCheckForAdd(index);
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = element;
        size = s + 1;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    @Override
    public T get(T element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public T getFirst() {
        return (T) elementData[0];
    }

    @Override
    public T getLast() {
        return (T) elementData[size - 1];
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        elementData[index] = element;
    }

    @Override
    public boolean remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;
        fastRemove(es, index);
        return true;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                '}';
    }

    private void add(T element, Object[] elementData, int s) {
        if (s == elementData.length) {
            elementData = grow();
        }
        elementData[s] = element;
        size = s + 1;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != EMPTY_ELEMENTDATA) {
            int newCapacity = minCapacity;
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }
}
