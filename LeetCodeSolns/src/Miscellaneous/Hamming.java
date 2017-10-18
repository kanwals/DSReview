class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        return countSetBits(xor);
    }

    int countSetBits(int n){
        int count = 0;
        while(n>0){
            n &= (n-1);
            count++;
        }
        return count;
    }
}