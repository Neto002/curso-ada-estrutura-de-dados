package com.neto.dataStructure;

public class Stack<T> {
    private Node<T> top;
    private int height;

    public Stack(T value) {
        this.top = new Node<>(value);
        this.height = 1;
    }

    public Stack() {
        this.height = 0;
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

    public void getTop() {
        if (this.top == null) {
            System.out.println("Pilha vazia!");
        } else {
            System.out.println("Topo: " + this.top.value);
        }
    }

    public int getHeight() {
       return this.height;
    }

    public void print() {
        System.out.println("##################");
        Node<T> temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("##################");
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);

        if (height != 0) {
            newNode.next = top;
        }
        top = newNode;

        height++;
    }

    public T pop() {
        if (height == 0) {
            return null;
        }

        Node<T> temp = top;
        top = top.next;
        temp.next = null;
        height--;

        return temp.value;
    }
}
