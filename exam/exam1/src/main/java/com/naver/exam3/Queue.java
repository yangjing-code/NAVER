package com.naver.exam3;

public class Queue<T> {
    private int size;
    private int header;
    private int tail;
    private int length;
    private Object[] array;

    public Queue Queue(int length) {
        this.length = length;
        array = new Object[length];
        tail = header = size = 0;
        return this;
    }

    public Queue clear() {
        tail = header = size = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        return this;
    }


    public boolean isEmpty() {
        if (tail == header) {
            return true;
        }
        return false;
    }

    public int length() {
        return size;
    }

    public boolean push(T data) {
        if (header == tail) {
            header = 0;
            array[header] = data;
            tail = 1;
            size++;

        } else {
            array[tail] = data;
            tail = tail + 1;
            size++;

        }
        return true;
    }

    public T Pop() {
        if (header == tail) {
            return null;
        }
        T date = (T) array[header];
        header = header + 1;
        size--;
        return date;
    }
}
