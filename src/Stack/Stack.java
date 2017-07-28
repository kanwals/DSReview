package Stack;

/**
 * Created by Gurkanwal on 7/26/2017.
 */
public class Stack {
    static final int MAX = 10;
    int top;
    int a[] = new int[MAX];

    Stack(){
        top = -1;
    }

    boolean isEmpty(){
        return ( top < 0);
    }

    boolean push(int x){
        if(top >= MAX - 1){
            System.out.println("Stack Overflow");
            return false;
        }else{
            a[++top] = x;
            return true;
        }
    }

    int pop(){
        if(top<0){
            System.out.println("Stack Underflow");
            return 0;
        }else{
            return a[top--];
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        for(int i=1;i<=100;i++){
            stack.push(i);
        }
        System.out.println("Popping stuff:");
        for(int i=1;i<=101;i++){
            System.out.println(stack.pop());
        }
    }
}
