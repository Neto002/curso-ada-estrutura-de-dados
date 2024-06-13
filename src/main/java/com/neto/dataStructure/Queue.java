package com.neto.dataStructure;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int length;

    public Queue(T value) {
        Node<T> node = new Node<>(value);
        first = node;
        last = node;
        length = 1;
    }

    public Queue() {
        length = 0;
    }

    public static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public T getFirst() {
        return first.value;
    }

    public T getLast() {
        return last.value;
    }

    public int size() {
        return length;
    }

    public void print() {
        System.out.println("#############");
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("#############");
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (length == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public T dequeue() {
        if (length == 0) {
            return null;
        }
        Node<T> temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp.getValue();
    }

    @Override
    public String toString() {
        Node<T> temp = first;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (temp != null) {
            stringBuilder.append(temp.value);
            temp = temp.next;
            if (temp != null) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
