package de.nickstrohm.queue;

import sun.plugin.dom.exception.InvalidAccessException;

public class Queue<T extends Object> {
    private int _pointer = 0;
    private Object[] _queue;

    public Queue(int size) {
        _queue = new Object[size];
    }

    public T front() {
        return (T)_queue[0];
    }

    public void enqueue(T x) {
        if (isFull()) {
            throw new StackOverflowError("This queue is full.");
        }

        _queue[_pointer] = x;
        _pointer++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new InvalidAccessException("There is no element in the queue.");
        }

        T tmp = (T)_queue[0];
        _pointer--;
        shiftLeft();
        return tmp;
    }

    public boolean isFull() {
        boolean isFull = true;
        for (int i = 0; i < _queue.length; i++) {
            if (_queue[i] == null) {
                isFull = false;
            }
        }

        return isFull;
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < _queue.length; i++) {
            if (_queue[i] != null) {
                isEmpty = false;
            }
        }

        return isEmpty;
    }

    public void write() {
        System.out.println(Main.strJoin(_queue, ", "));
    }

    private void shiftLeft() {
        for (int i = 0; i < _queue.length - 1; i++) {
            _queue[i] = _queue[i + 1];
        }

        _queue[_pointer] = null;
    }
}
