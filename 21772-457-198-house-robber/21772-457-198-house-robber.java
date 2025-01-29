class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        int prev1 =0, prev2 = 0;
        for( int num : nums){
           int temp = Math.max(prev1,prev2 + num);
           prev2 = prev1;
           prev1 = temp;
        }
        return prev1;
    }
}