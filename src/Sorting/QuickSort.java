
package Sorting;

import java.util.Arrays;

/**
 *
 * @author Gurkanwal
 */
public class QuickSort {
    
    public static void main(String[] args) {
        int[] data = {4, -5, 4, -1, 8};
        
        System.out.println("INPUT: " +Arrays.toString(data));
        QuickSort obj = new QuickSort();
        obj.sort(data);
        System.out.println("OUTPUT: " +Arrays.toString(obj.data));
    }
    private int[] data;
    
    public void sort(int[] data){
        this.data=data;
        quickSort(0,this.data.length-1);
    }
    
    private void quickSort(int low, int high){
        if(low<high){
            int indexChosenByMedian = low + (high-low)/2;
            int i=low;
            int j=high;
//            System.out.println("low: "+low+"    high: "+high+"  Index: "+indexChosenByMedian);
//            System.out.println("i: "+i+"    j: "+j);
//            System.out.println("ACTUAL Before this run: " + Arrays.toString(data));

            while(i<=j){
                while(data[i]<data[indexChosenByMedian]){
                    i++;
                }
                while(data[j]>data[indexChosenByMedian]){
                    j--;
                }
                if(i<=j){
                    swap(i,j);
                    i++;j--;
                }            
            
                if (low < j)
                    quickSort(low, j);
                if (i < high)
                    quickSort(i, high);
            }
        }
    }
    
    private void swap(int index1, int index2){
        System.out.println("SWAPPING "+data[index1]+" and "+data[index2]);

        int temp = data[index1];
        data[index1]=data[index2];
        data[index2]=temp;
    }
   
}
