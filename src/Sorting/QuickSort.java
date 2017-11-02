
package Sorting;

import java.util.Arrays;

/**
 *
 * @author Gurkanwal
 */
public class QuickSort {

    int[] data;
    QuickSort(int[] data){
        this.data = new int[data.length];
        this.data = data;
    }
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8};
        
        System.out.println("INPUT: " +Arrays.toString(data));
        QuickSort obj = new QuickSort(data);
        obj.sort();
        System.out.println("OUTPUT: " +Arrays.toString(obj.data));
    }

    private void qsort(int lo, int hi){
        if(hi<=lo) return;
        int part = partition(lo, hi);
        qsort(lo ,part-1);
        qsort(part+1, hi);
    }
    
    public void sort(){
//        quickSort(0,this.data.length-1);
        qsort(0,data.length - 1);
    }

    private int partition(int lo, int hi){
        int i = lo;
        int j = hi+1;

        while(true){
            while(i<hi && data[++i]<data[lo]);
            while(j>lo && data[--j]>data[lo]);
            if(i>=j) break;
            swap(i,j);
        }
        swap(lo,j);
        return j;
    }
    
//    private void quickSort(int[] data, int low, int high){
//        if(low<high){
//            int indexChosenByMedian = low + (high-low)/2;
//            int i=low;
//            int j=high;
////            System.out.println("low: "+low+"    high: "+high+"  Index: "+indexChosenByMedian);
////            System.out.println("i: "+i+"    j: "+j);
////            System.out.println("ACTUAL Before this run: " + Arrays.toString(data));
//
//            while(i<=j){
//                while(data[i]<data[indexChosenByMedian]){
//                    i++;
//                }
//                while(data[j]>data[indexChosenByMedian]){
//                    j--;
//                }
//                if(i<=j){
//                    swap(data,i,j);
//                    i++;j--;
//                }
//
//                if (low < j)
//                    quickSort(data, low, j);
//                if (i < high)
//                    quickSort(data, i, high);
//            }
//        }
//    }
    
    private void swap(int index1, int index2){
        System.out.println("SWAPPING "+data[index1]+" and "+data[index2]);

        int temp = data[index1];
        data[index1]=data[index2];
        data[index2]=temp;
    }
   
}
