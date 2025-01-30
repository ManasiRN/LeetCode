class Solution {
    public int rob(int[] nums) {
       if(nums.length == 1){
        return nums[0];
       } 
       int case1 = rob_line(Arrays.copyOfRange(nums,0,nums.length - 1));
       int case2 = rob_line(Arrays.copyOfRange(nums,1,nums.length));
       return Math.max(case1, case2);
    }
    public int rob_line(int [] nums){
        int prev = 0, curr = 0;
        for(int num : nums){
            int temp = curr;
            curr = Math.max(curr, prev + num);
            prev = temp;
        }
        return curr;
    }
    
}