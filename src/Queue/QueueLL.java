package Queue;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Gurkanwal on 7/28/2017.
 */
public class QueueLL<T> {
    ListNode front = null;
    ListNode rear = null;
    int len = 0;

    public int getCurrentLength(){
        return len;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public T peek(){
        if(isEmpty())
            throw new NoSuchElementException("Queue Underflow");
        return (T) front.val;
    }

    public void enqueue(T data){
        if (rear == null){
            front = rear = new ListNode(data);
        } else {
            ListNode newRear = new ListNode(data);
            rear.next = newRear;
            rear = newRear;
        }
        len++;
    }

    public T dequeue(){
        if(isEmpty())
            throw new NoSuchElementException("Queue Underflow");
        T val = (T)front.val;
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
        QueueLL<Integer> queue = new QueueLL<Integer>();
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

class ListNode<T>{
    ListNode next;
    T val;

    ListNode(T n){
        val = n;
        next = null;
    }
}