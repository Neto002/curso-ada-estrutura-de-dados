package com.neto.main;

import com.neto.dataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

public class MaiorValorArvore {

    public static List<Integer> largestValues(Tree<Integer> tree) {
        List<Integer> list = new ArrayList<>();

        solve(tree.root, 0, list);

        return list;
    }

    private static void solve(final Tree.Node<Integer> node, final int level, final List<Integer> list) {
        if (node == null) {
            return;
        }

        if (level == list.size()) {
            list.add(node.value);
        } else {
            list.set(level, Math.max(list.get(level), node.value));
        }

        solve(node.left, level + 1, list);
        solve(node.right, level + 1, list);
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insert(100);
        tree.insert(10);
        tree.insert(5);
        tree.insert(6);
        tree.insert(1);
        tree.insert(7);
        tree.insert(5);

        System.out.println(largestValues(tree));
    }

}
