package com.mycompany.semesterproject;

import java.util.Stack;

public class PostFixNotation {

    /**
     * method takes in a String expression and returns the answer
     * @param equation
     * @return answer
     */
    public static int evaluate(String equation) {
        //Stacks work like list
        Stack<Integer> digits = new Stack<>();  //Operand stack 123456789,10,11,12,13
        Stack<Character> operations = new Stack<>();  //Operator stack +,-,/,*
        
        //looks into String and converts to Char
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            
            if (Character.isDigit(c)){ //check if it is number
                //Entry is Digit, and it could be greater than a one-digit number
                int num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;//moves forward in the String
                    if (i < equation.length()) {
                        c = equation.charAt(i);
                    } else {
                        break;
                    }
                }
                i--;
                digits.push(num);
            } 
            
            
            else if (c == '(') {
                operations.push(c);   //push character to operators stack
            } //Closed brace, evaluate the entire brace
            else if (c == ')') {
                while (operations.peek() != '(') {
                    int output = performOperation(digits, operations);
                    digits.push(output);   //push result back to stack
                }
                operations.pop();
            }
                
             // current character is operator
            else if (isOperator(c)) {
                while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) { 
                    int output = performOperation(digits, operations);
                    digits.push(output);   //push result back to stack
                }
                operations.push(c);   //push the current operator to stack
            }
        }

        //final answer
        while (!operations.isEmpty()) {
            int output = performOperation(digits, operations);
            digits.push(output);   //push final result back to stack
        }
        return digits.pop();
    }
    
    /**
     *
     * method checks operators importance: PEMDAS
     * 
     */
    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    /**
     *
     * method performs the Operation
     * 
     */
   private static int performOperation(Stack<Integer> operands, Stack<Character> operations) {
        int a = operands.pop();
        int b = operands.pop();
        char operation = operations.pop();
        switch (operation) {
            case '+': // if addition
                return a + b; // adds the two values
            case '-': //if subtraction
                return b - a; //subtracts the two values
            case '*': //if multiply 
                return a * b; //multiplies the two values
            case '/': //if division
                return b / a; //divides the two values
        }
        return 0;
    }
   
   /**
     * method checks whether if character is an operator 
     */
    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '/' || c == '*');
    }
}
