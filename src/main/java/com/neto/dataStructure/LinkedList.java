package com.neto.dataStructure;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public LinkedList() {
        this.makeEmpty();
    }

    public LinkedList(T data) {
        length = 1;
        Node<T> newNode = new Node<>(data);
        head = newNode;
        tail = newNode;
    }

    public T getHead() {
        return this.head.data;
    }

    public T getTail() {
        return this.tail.data;
    }

    public int getLength() {
        return this.length;
    }

    public void makeEmpty() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void print() {
        System.out.println("####################");
        Node<T> temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("####################");
    }

    public T get(int index) {
        if (invalidIndex(index)) {
            return null;
        }
        Node<T> temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    private Node<T> getNode(int index) {
        if (invalidIndex(index)) {
            return null;
        }
        Node<T> temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private boolean invalidIndex(int index) {
        return index < 0 || index >= this.length;
    }

    public boolean set(int index, T data) {
        Node<T> temp = getNode(index);

        if (temp == null) {
            return false;
        }

        temp.data = data;

        return true;
    }

    public void prepend(T data) {
        Node<T> newNode = new Node<>(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public boolean insert(int index, T data) {
        if (invalidIndex(index)) {
            return false;
        }

        if (index == 0) {
            prepend(data);
            return true;
        }

        if (index == this.length - 1) {
            append(data);
            return true;
        }

        Node<T> newNode = new Node<>(data);

        Node<T> temp = getNode(index - 1);

        if (temp == null) {
            return false;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }

    public Node<T> removeFirst() {
        if (length == 0) {
            return null;
        }

        Node<T> temp = this.head;
        this.head = this.head.next;
        temp.next = null;

        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node<T> removeLast() {
        if (length == 0) {
            return null;
        }

        Node<T> temp = this.head;
        Node<T> removed = null;

        while (temp.next != this.tail) {
            temp = temp.next;
        }

        removed = tail;
        this.tail = temp;
        temp.next = null;

        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return removed;
    }

    public Node<T> delete(int index) {
        if (invalidIndex(index)) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == this.length - 1) {
            return removeLast();
        }

        Node<T> prev = getNode(index - 1);

        if (prev == null) {
            return null;
        }

        Node<T> current = prev.next;

        prev.next = current.next;
        current.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return current;
    }
}
