class Solution {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
         for (int n: nums){

            if (i < 1 || n > nums[i - 1]){
                nums[i] = n;
                i++;
            }
         }
         return i;
    }
    public static void main (String args[]){
        int nums [] = {1,1,2,2,2,3,3,4};
        System.out.print(removeDuplicates(nums));
    }
}