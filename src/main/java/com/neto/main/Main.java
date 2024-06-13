package com.neto.main;

import com.neto.dataStructure.Stack;
import com.neto.dataStructure.Stack.Node;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        invert(numbers);

        int t,m,c;
        t = 1;
        m = 5;
        c = 10;
        c = c * (t + 1);
        while (t < m) {
            t = t + 1;
            c = c * (t + 1);
        }
        System.out.println(c);
    }

    private static void invert(int[] numbers) {
        Stack<Integer> stack = new Stack<>(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }
        Integer node = stack.pop();
        while (node != null) {
            System.out.println(node);
            node = stack.pop();
        }
    }
}