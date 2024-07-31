class Solution {
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for(; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
            if(nums[i] > target){
                break;
            }
           
        }
         return i;
        
    }

    public static void main (String args){
        // Solution sol = new Solution();
        int [] nums = {1,4,7,9};
        int target = 4;
        int result = searchInsert(nums,target);
        System.out.println(result);

    }
}