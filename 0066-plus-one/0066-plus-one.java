class Solution {
    public static int[] plusOne(int[] digits) {
        int  n = digits.length; 
        for(int i = n-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i] ++;
                return digits;
            }

            digits[i] = 0;
            
        }
        int newarr [] = new int [n+1];
            newarr[0] = 1;
            return newarr;
    }
    public static void main (String args[]){
            int n[] = {1,2,3};
            System.out.println(plusOne(n));
        
    }
}