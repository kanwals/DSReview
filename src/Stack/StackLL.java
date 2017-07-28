package Stack;

/**
 * Created by Gurkanwal on 7/26/2017.
 */
public class StackLL {
    ListNode stackHead = null;

    void push(int x){
        if(stackHead == null){
            stackHead = new ListNode(x);
        }else{
            ListNode newHead = new ListNode(x);
            newHead.next = stackHead;
            stackHead = newHead;
        }
    }

    int pop(){
        if(stackHead == null){
            System.out.println("Stack Underflow");
            return 0;
        }else{
            ListNode newHead = stackHead.next;
            int val = stackHead.val;
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
        StackLL stack = new StackLL();
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

class ListNode{
    ListNode next;
    int val;

    ListNode(int x){
        val = x;
        next = null;
    }
}

