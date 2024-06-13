package com.neto.dataStructure;

public class BinarySearchTree {

    public Node root;

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(final Node node) {
        // E R D
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    private void insert(final Node node, final int value) {
        if (node == null || value == root.value) {
            return;
        }

        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                node.left = new Node(value);
            }
        } else {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                node.right = new Node(value);
            }
        }
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(final Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        if (value < node.value) {
            return contains(node.left, value);
        } else {
            return contains(node.right, value);
        }
    }

    public int minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public Node deleteNode(int value) {
        return deleteNode(root, value);
    }

    private Node deleteNode(final Node node, int value) {
        if (root == null) {
            return null;
        }

        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
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
            int minValue = minValue(node.right);
            node.value = minValue;
            node.right = deleteNode(node.right, minValue);
        }

        return node;
    }
}
