package Queue;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Gurkanwal on 7/28/2017.
 */
public class QueueLL {
    ListNode front = null;
    ListNode rear = null;
    int len = 0;

    public int getCurrentLength(){
        return len;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public int peek(){
        if(isEmpty())
            throw new NoSuchElementException("Queue Underflow");
        return front.val;
    }

    public void enqueue(int data){
        if (rear == null){
            front = rear = new ListNode(data);
        } else {
            ListNode newRear = new ListNode(data);
            rear.next = newRear;
            rear = newRear;
        }
        len++;
    }

    public int dequeue(){
        if(isEmpty())
            throw new NoSuchElementException("Queue Underflow");
        int val = front.val;
        if(front == rear){
            front = rear = null;
        } else
            front = front.next;
        len--;
        return val;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue Empty.");
            return;
        }
        System.out.println("The Queue contains: ");
        for(ListNode iter = front; iter != null; iter = iter.next){
            System.out.print(iter.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLL queue = new QueueLL();
        for (int i = 1; i < 11; i++) {
            queue.enqueue(i);
        }
        queue.display();
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.dequeue());
        }
        queue.display();
        for (int i = 0; i < 9; i++) {
            System.out.println(queue.dequeue());
        }
    }

}

class ListNode{
    ListNode next;
    int val;

    ListNode(int n){
        val = n;
        next = null;
    }
}