package Heap;

import java.util.Arrays;
import java.util.Random;

public class Heap {

    private int[] H;
    public int heapLength;

    Heap() {
        this.H = new int[2];
        Arrays.fill(H,-1);
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
        H[heapLength] = data;
        heapifyUp(heapLength++);
    }

    public int extractMin(){
        int result = -1;
        if(!isEmpty()){
            result = H[0];
            swapHeapElements(0,--heapLength);
            H[heapLength] = -1;
            heapifyDown(0);
        }
        return result;
    }

    public int extract(int index){
        int result = -1;
        if(!isEmpty() && index < heapLength){
            result = H[index];
            swapHeapElements(index,--heapLength);
            H[heapLength] = -1;

            //if the element present at "index" is smaller than parent, heapifyUp. Else heapify Down.
            if(H[index] < H[(index-1)/2]){
                heapifyUp(index);
            }
            else heapifyDown(index);
        }
        return result;
    }

    private void heapifyUp(int vulnerableIndex){
        if(vulnerableIndex >= 1){
            int parentIndex = (vulnerableIndex-1)/2;
            if(H[vulnerableIndex] < H[parentIndex]){
                swapHeapElements(vulnerableIndex, parentIndex);
                heapifyUp(parentIndex);
            }
        }
    }

    private void heapifyDown(int vulnerableIndex){
        if(2*vulnerableIndex + 2 > heapLength)
            return;
        int potentialChildIndexForSwapping = -1;
        if(2*vulnerableIndex + 2 < heapLength){
            //check which of the childs is smaller, and swap with that
            int leftChildIndex = 2*vulnerableIndex + 1;
            int rightChildIndex = 2*vulnerableIndex + 2;
            if(H[leftChildIndex] < H[rightChildIndex])
                potentialChildIndexForSwapping = leftChildIndex;
            else
                potentialChildIndexForSwapping = rightChildIndex;
        }
        else if(2*vulnerableIndex + 2 == heapLength){
            potentialChildIndexForSwapping = 2*vulnerableIndex + 1;
        }
        if(H[potentialChildIndexForSwapping]<H[vulnerableIndex]){
            swapHeapElements(potentialChildIndexForSwapping,vulnerableIndex);
            heapifyDown(potentialChildIndexForSwapping);
        }
    }

    public boolean isEmpty(){
        if (heapLength == 0)
            return true;
        return false;
    }

    private void swapHeapElements(int index1, int index2){
        int temp = H[index1];
        H[index1] = H[index2];
        H[index2] = temp;
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
                throw new NumberFormatException("All elements in the Heap must be greater than Zero");
        }
    }

    private int getTwosPower(int num){
        int i;
        for (i = 1; 2*i > num ; i++) {}
        return i;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        for (int i = 0; i < 15 ; i++) {
            Random rand = new Random();
            int n = rand.nextInt(100) + 1;
            heap.addElement(n);
            heap.displayHeap();
        }
//        System.out.println("Extracted Element: " + heap.extract(4));
//        heap.displayHeap();
        for (int i = 0; i < 15 ; i++) {
            System.out.println(heap.extract(0));
//            heap.displayHeap();
//            System.out.println("======");
        }
    }
}
