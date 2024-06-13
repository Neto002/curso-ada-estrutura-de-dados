package com.neto.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T> {

    public Node<T> root;

    public static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(final Node<T> node) {
        // R E D
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(final Node<T> node) {
        // E R D
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(final Node<T> node) {
        // E D R
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public void bfs() {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            System.out.println(node.value);
        }
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Queue<Node<T>> queue = new LinkedList<>();
            queue.add(this.root);

            while (!queue.isEmpty()) {
                Node<T> currentNode = queue.remove();

                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.add(currentNode.left);
                }

                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }
    }
}
