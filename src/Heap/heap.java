package Heap;

import java.util.Arrays;

public class heap {

    private int[] H;
    public int heapLength;

    public void heap() {
        this.H = new int[2];
        this.heapLength = 0;
    }

    public int peek() throws IllegalAccessException {
        if(!isEmpty())
            return H[0];
        else
            throw new IllegalAccessException("The Heap is empty.");
    }

    public void addElement(int data){
        if(heapLength == H.length)
            expandHeap();
        H[heapLength++] = data;
        heapifyUp(heapLength);
    }

    private void heapifyUp(int vulnerableIndex){

    }

    public boolean isEmpty(){
        if (heapLength == 0)
            return true;
        return false;
    }

    private void expandHeap(){
        int currentSize = H.length;
        int[] newHeap = new int[currentSize*2];
        Arrays.fill(newHeap, -1);
        System.arraycopy(H,0, newHeap, 0, currentSize);
        this.H = newHeap;
    }

    public void displayHeap(){
        System.out.println("\nHeap contents: " + Arrays.toString(this.H));
    }

    private void checkPositive(int[] H){
        for (int i = 0; i < H.length ; i++) {
            if(H[i]<0)
                throw new NumberFormatException("All elements in the heap must be greater than Zero");
        }
    }

    private int getTwosPower(int num){
        int i;
        for (i = 1; 2*i > num ; i++) {}
        return i;
    }

}
