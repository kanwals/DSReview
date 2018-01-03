import java.util.Stack;

class Solution {
    public int calculate(String s) {

        String infix = cleanExpression(s);
        System.out.println(infix);
        if(infix.length()==0) return 0;
        return evaluatePostfix(infixToPostfix(infix));
    }

    String cleanExpression(String s){
        s = s.trim().replaceAll(" +","");
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isDigit(c))
                sb.append(c);
            else sb.append(" ").append(c).append(" ");
        }
        return sb.toString().trim();
    }

    String infixToPostfix(String infix){
        Stack<Character> digits = new Stack<Character>();
        String[] chars = infix.split(" ");
        StringBuilder post = new StringBuilder();
        for(String c: chars){
            if(c.matches("[0-9]+")){
                post.append(c).append(" ");
            } else {
                int p = getPriority(c.charAt(0));
                while(!digits.isEmpty() && p<getPriority(digits.peek()))
                    post.append(digits.pop()).append(" ");
                digits.push(c.charAt(0));
            }
        }
        while(!digits.isEmpty())
            post.append(digits.pop()).append(" ");
        System.out.println(post.toString().trim());
        return post.toString().trim();
    }

    int getPriority(char c){
        switch(c){
            case '+': return 1;
            case '-': return 2;
            case '*': return 3;
            case '/': return 4;
            default: return 0;
        }
    }

    int evaluatePostfix(String s){
        if(s.length()==0) return 0;
        String[] chars = s.split(" ");
        Stack<Double> nums = new Stack<Double>();
        for(String c: chars){
            if(c.matches("[0-9]+"))
                nums.push(Double.parseDouble(c));
            else{
                Double a = nums.pop();
                Double b = nums.pop();
                Double val = doOperation(c.charAt(0),b,a);
                System.out.println(a+" " + b + " " +val);
                nums.push(val);
            }
        }
        return nums.pop().intValue();
    }

    Double doOperation(char op, Double a, Double b){
        switch(op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }
        throw new IllegalArgumentException("Operation "+op+" not supported");
    }
}