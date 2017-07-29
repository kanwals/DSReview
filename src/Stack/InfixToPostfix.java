package Stack;

import java.util.NoSuchElementException;

/**
 * Created by Gurkanwal on 7/29/2017.
 */
public class InfixToPostfix {
    private static int getPriority(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String infix){

        StackLL<Character> stack = new StackLL<Character>();
        int operandCount = 0, operatorCount = 0;

        String postfix = "";
        for (int i=0; i<infix.length(); i++) {
            char ch = infix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                postfix += ch; operandCount++;
            } else if (ch == '('){
                stack.push(ch);
            } else if (ch == ')'){
                try {
                    while (stack.peek()!='('){
                        postfix += stack.pop();
                    }
                } catch (NoSuchElementException e){
                    throw new IllegalArgumentException("Not a valid infix Expression. Please check bracket placements.");
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && getPriority(ch) <= getPriority(stack.peek()))
                    postfix += stack.pop();
                stack.push(ch); operatorCount++;
            }
        }
        if(operandCount != operatorCount + 1)
            throw new IllegalArgumentException("Not a valid infix Expression.");
        while(!stack.isEmpty())
            postfix += stack.pop();

        return postfix;
    }
    private static int doOperation(int a, int b, char op){
        switch(op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
            case '^': return (int)Math.pow(a,b);
        }
        throw new IllegalArgumentException("Operator "+op+" not supported.");
    }

    public static int evaluatePostfix(String postfix){

        StackLL<Integer> stack = new StackLL<Integer>();
        for (int i=0; i<postfix.length(); i++){
            char ch = postfix.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(Character.getNumericValue(ch));
                System.out.println("--Top of stack: "+stack.peek());
            }
            else{
                int a = stack.pop();
                int b = stack.pop();
                stack.push(doOperation(b,a,ch));
                System.out.println("Top of stack: "+stack.peek());
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

        String infix = "2*(3+(4^2))-3";
        System.out.println("Infix Expression:\t"+infix);
        System.out.println("Postfix Expression:\t"+ infixToPostfix(infix));
        System.out.println("Result: "+evaluatePostfix(infixToPostfix(infix)));
    }
}

