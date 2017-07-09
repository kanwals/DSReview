package Sorting;

import java.util.Arrays;

/**
 *
 * @author Gurkanwal
 */
public class MergeSort {

    public static void main(String[] args) {
//        if (args.length == 0) {
//            throw new IllegalArgumentException("No Integer arguments passed. Example: -7 3 5 -8 1 3");
//        }
        int[] data = {600,-200,50,-7,9,-10,43,-56};
        
        System.out.println("INPUT: " +Arrays.toString(data));
        MergeSort obj = new MergeSort();
        obj.sort(data);
        System.out.println("OUTPUT: " +Arrays.toString(obj.data));
    }
    private int[] data;
    private int[] helper;
    private int number;

    private void mergeSort(int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    public void sort(int[] args) {
        this.data = args;
        this.number = data.length;
        this.helper = new int[this.number];
        mergeSort(0, this.number - 1);
    }

    private void merge(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = data[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (helper[i] <= helper[j]) {
                data[k++] = helper[i++];
            } else {
                data[k++] = helper[j++];
            }
        }

        while (i <= mid) {
            data[k++] = helper[i++];
        }

        //NOT required though, as the upper half of the array is already at its correct posiyion
        while (j <= high) {
            data[k++] = helper[j++];
        }
        
//        System.out.println("low: "+low+ "   mid: "+mid+"    high: "+high);
//        System.out.println("i: "+i+"    j: "+j+"    k: "+k);
//        System.out.println("HELPER: " + Arrays.toString(helper));
//        System.out.println("ACTUAL: " + Arrays.toString(data));
//        System.out.println("=============================");
    }

    
}
