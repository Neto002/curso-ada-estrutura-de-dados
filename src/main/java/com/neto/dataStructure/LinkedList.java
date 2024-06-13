package com.neto.dataStructure;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList("elemento 1");
        System.out.println(list.get(0));
    }

    public LinkedList(String data) {
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        if (this.head == null) {
            return null;
        }
        return this.head;
    }

    public Node getTail() {
        if (this.tail == null) {
            return null;
        }
        return this.tail;
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
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("####################");
    }

    public Node get(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, String data) {
        Node temp = get(index);

        if (temp == null) {
            return false;
        }

        temp.data = data;

        return true;
    }

    public void prepend(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void append(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public boolean insert(int index, String data) {
        if (index < 0 || index >= this.length) {
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

        Node newNode = new Node(data);

        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }

        Node temp = this.head;
        this.head = this.head.next;
        temp.next = null;

        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }

        Node temp = this.head;
        Node removed = null;

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

    public Node delete(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == this.length - 1) {
            return removeLast();
        }

        Node prev = get(index - 1);
        Node current = prev.next;

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
