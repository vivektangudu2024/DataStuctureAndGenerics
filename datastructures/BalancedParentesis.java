package com.day14.datastructures;



public class BalancedParentesis {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>(expression.length());

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false; // Unbalanced closing parenthesis
                }
            }
        }

        return stack.isEmpty(); // If stack is empty, the expression is balanced
    }

    public static void main(String[] args) {
        String arithmeticExpression = "(5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3)";
        boolean result = isBalanced(arithmeticExpression);

        System.out.println("Arithmetic Expression is Balanced: " + result);
    }
}

