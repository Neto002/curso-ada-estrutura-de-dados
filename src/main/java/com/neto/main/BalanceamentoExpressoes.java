package com.neto.main;

import com.neto.dataStructure.Stack;

import java.util.Set;

public class BalanceamentoExpressoes {
    public static final String EXP = "2*(3+4+5*[2+3])";

    public static boolean solve(String exp) {
        Set<Character> openSymbols = Set.of('(', '[', '{');
        Set<Character> closeSymbols = Set.of(')', ']', '}');
        Stack<Character> stack = new Stack<>();

        for (char c: exp.toCharArray()) {
            if (openSymbols.contains(c)) {
                stack.push(c);
            }
            if (closeSymbols.contains(c)) {
                if (stack.getHeight() == 0) {
                    return false;
                }
                char open = stack.pop();
                if (open == '(' && c != ')') {
                    return false;
                }
                if (open == '[' && c != ']') {
                    return false;
                }
                if (open == '{' && c != '}') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        System.out.println(solve(EXP));
    }
}
