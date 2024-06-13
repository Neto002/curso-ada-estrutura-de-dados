package com.neto.dataStructure;

public class BinarySearchTree<T extends Comparable<T>> {

    public Node<T> root;

    public static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;

        public Node(T value) {
            this.value = value;
        }
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

    public void insert(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            insert(root, value);
        }
    }

    private void insert(final Node<T> node, final T value) {
        if (node == null || value == root.value) {
            return;
        }

//        if (value < node.value) {
        if (value.compareTo(node.value) < 0 ) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                node.left = new Node<T>(value);
            }
        } else {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                node.right = new Node<T>(value);
            }
        }
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(final Node<T> node, T value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
//        if (value < node.value) {
        if (value.compareTo(node.value) < 0 ) {
            return contains(node.left, value);
        } else {
            return contains(node.right, value);
        }
    }

    public T minValue(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public Node<T> deleteNode(T value) {
        return deleteNode(root, value);
    }

    private Node<T> deleteNode(final Node<T> node, T value) {
        if (root == null) {
            return null;
        }

//        if (value < node.value) {
        if (value.compareTo(node.value) < 0) {
            node.left = deleteNode(node.left, value);
//        } else if (value > node.value) {
        } else if (value.compareTo(node.value) > 0) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            T minValue = minValue(node.right);
            node.value = minValue;
            node.right = deleteNode(node.right, minValue);
        }

        return node;
    }
}
