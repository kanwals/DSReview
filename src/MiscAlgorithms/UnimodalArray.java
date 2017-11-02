package MiscAlgorithms;

public class UnimodalArray {
    int[] array = {1,2,6,8,6,5,4};

    void findPeek(int low, int high){
        int mid = low + (high-low)/2;
        if(array[mid-1]<array[mid] && array[mid]<array[mid+1]){
            findPeek(mid+1,high);
        } else if (array[mid-1]>array[mid] && array[mid]>array[mid+1]){
            findPeek(low,mid);
        } else
            System.out.println(array[mid]);
    }

    public static void main(String[] args) {
        UnimodalArray ua = new UnimodalArray();
        ua.findPeek(0, ua.array.length-1);
    }
}
