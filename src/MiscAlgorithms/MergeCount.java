package MiscAlgorithms;

import java.util.Arrays;

public class MergeCount {

    int[] input;
    int[] helper;


    MergeCount(int[] data){
        input = new int[data.length];
        input = data;
    }

    int mergeAndCount(int begin, int mid, int end){

        for (int i = begin; i <= end; i++) {
            helper[i] = input[i];
        }

        int count = 0;
        int i = begin;
        int j = mid+1;
        int k = begin;

        while (i<=mid && j<=end){
            if(helper[i]<=helper[j]){
                input[k++] = helper[i++];
            } else {
                count += (mid - i + 1);
                input[k++] = helper[j++];
            }
        }

        while (i <= mid) {
            input[k++] = helper[i++];
        }

//        NOT required though, as the upper half of the array is already at its correct position
        while (j <= end) {
            input[k++] = helper[j++];
        }
        return count;
    }

    int sortAndCount(int low, int high){
        if(low == high)
            return 0;

        int mid = low + (high - low) / 2;
        int leftCount = sortAndCount(low, mid);
        int rightCount = sortAndCount(mid+1, high);

        return leftCount+rightCount+mergeAndCount(low, mid, high);
    }



    public static void main(String[] args) {
        int[] input = {5,4,3,2,1};
        MergeCount mc = new MergeCount(input);
        mc.helper = new int[input.length];
        System.out.println(mc.sortAndCount(0, input.length-1));
    }
}
