package Queue;

import java.util.NoSuchElementException;

/**
 * Created by Gurkanwal on 7/28/2017.
 */
public class QueueArray {
    int front, rear, size, len;
    int q[];

    QueueArray(int size){
        this.size = size;
        front = -1;
        rear = -1;
        len = 0;
        q = new int[size];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public boolean isFull(){
        return front == 0 && rear == size-1;
    }

    public int peek(){
        if(isEmpty())
            throw new NoSuchElementException("Queue Underflow");
        return q[front];
    }

    public void enqueue(int data){
        if(rear == -1){
            front = rear = 0;
            q[rear] = data;
        } else if (rear + 1 >= size){
            throw new IndexOutOfBoundsException("Queue Overflow");
        } else {
            q[++rear] = data;
        }
        len++;
    }

    public int dequeque(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue Underflow");
        } else {
            int val = q[front];
            if(front == rear){
                front = rear = -1;
            } else
                front++;
            len--;
            return val;
        }
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue Empty");
            return;
        }
        for (int i = front; i <= rear; i++){
            System.out.print(q[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(10);
        for (int i = 1; i < 11; i++) {
            queue.enqueue(i);
        }
        queue.display();
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.dequeque());
        }
        queue.display();
        for (int i = 0; i < 9; i++) {
            System.out.println(queue.dequeque());
        }
    }
}
