package Stack;

import java.util.NoSuchElementException;

/**
 * Created by Gurkanwal on 7/26/2017.
 */
public class StackLL<T> {
    ListNode stackHead = null;

    T peek(){
        if(isEmpty())
            throw new NoSuchElementException("Stack Underflow");
        else return (T) stackHead.val;
    }

    void push(T x){
        if(isEmpty()){
            stackHead = new ListNode(x);
        }else{
            ListNode newHead = new ListNode(x);
            newHead.next = stackHead;
            stackHead = newHead;
        }
    }

    T pop(){
        if(isEmpty()){
            throw new NoSuchElementException("Stack Underflow");
        }else{
            ListNode newHead = stackHead.next;
            T val = (T) stackHead.val;
            stackHead = newHead;
            return val;
        }
    }

    boolean isEmpty(){
        if(stackHead == null){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Pushing stuff...");
        StackLL<Integer> stack = new StackLL<Integer>();
        for(int i=1;i<=10;i++){
            stack.push(i);
        }

        System.out.println("Popping stuff:");
        for(int i=1;i<=11;i++){
            if(!stack.isEmpty())
                System.out.println(stack.pop());
            else{
                System.out.println("Stack is now empty.");
                break;
            }
        }
    }
}

class ListNode<T>{
    ListNode next;
    T val;

    ListNode(T x){
        val = x;
        next = null;
    }
}

