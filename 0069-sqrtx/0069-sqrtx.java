class Solution {
    public static int mySqrt(int x) {
       int left = 1, right = x, result = 0;
       while(left <= right) {
        int mid = left + (right - left)/2;
        if(mid <= x/mid){
            result = mid;
            left = mid + 1; 
        }
        else{
            right = mid - 1;
        }
       }
       return result;
    }
    public static void main (String args[]){
        int n = 8;
        System.out.println(mySqrt(n));
    }
}