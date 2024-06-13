package com.neto.main;

import com.neto.dataStructure.Queue;
import com.neto.dataStructure.Queue.Node;

import java.util.Random;

public class FilaDeAtendimento {
    public static void main(String[] args) {
        int n = 5;
        int cliente = new Random().nextInt(101);
        Queue<Integer> queue = new Queue<>(cliente);
        System.out.println("Chegou cliente: " + cliente);
        for (int i = 1; i < n; i++) {
            cliente = new Random().nextInt(101);
            System.out.println("Chegou cliente: " + cliente);
            queue.enqueue(cliente);
        }

        // Atendimento
        Integer node = queue.dequeue();
        while (node != null) {
            System.out.println("Cliente " + node + " atendido!");
            node = queue.dequeue();
        }
    }
}
