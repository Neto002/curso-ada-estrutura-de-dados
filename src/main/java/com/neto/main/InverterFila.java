package com.neto.main;

import com.neto.dataStructure.Queue;

public class InverterFila {

    public static Queue<Integer> solve(Queue<Integer> queue, int k) {
        solveRecursive(queue, k);
        int n = queue.size() - k;
        while (n-- > 0) {
            int element = queue.dequeue();
            queue.enqueue(element);
        }
        return queue;
    }

    private static void solveRecursive(Queue<Integer> queue, int k) {
        if (k == 0) {
            return;
        }
        int element = queue.dequeue();
        solveRecursive(queue, k - 1);
        queue.enqueue(element);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(solve(queue, 3));
    }
}
