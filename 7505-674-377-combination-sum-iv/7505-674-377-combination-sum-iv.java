class Solution {
    public int helper(int nums [], int tar, int dp[]){
        if(tar == 0){
            return 1;
        }
        if(dp[tar]!= -1 ) return dp[tar];
        int ways = 0;
        for(int i = 0; i<nums.length; i++){
            if(tar-nums[i] >= 0){
                ways+=helper(nums,tar-nums[i],dp);
            }
        }
        return dp[tar] = ways;
    }
    public int combinationSum4(int[] nums, int target) {
      int n = nums.length;
      int dp[] = new int [target+1];
      Arrays.fill(dp,-1);
      return helper(nums, target,dp);  
    }
}