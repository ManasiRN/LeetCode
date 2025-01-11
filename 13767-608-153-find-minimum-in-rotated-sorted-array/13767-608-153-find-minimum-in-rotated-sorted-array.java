class Solution {
        public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1; // Fixed spelling and variable name
        
        while (low < high) {
            int mid = low + (high - low) / 2; // Correct mid calculation
            
            if (nums[mid] > nums[high]) {
                low = mid + 1; // Move to the right half
            } else {
                high = mid; // Move to the left half
            }
        }
        
        return nums[low]; // `low` will point to the minimum element
    }
}