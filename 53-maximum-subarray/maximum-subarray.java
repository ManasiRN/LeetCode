class Solution {
    public int maxSubArray(int[] nums) {
        int cursum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            cursum = Math.max(num, cursum + num);
            maxSum = Math.max(maxSum, cursum);
        }

        return maxSum;
    }
}
