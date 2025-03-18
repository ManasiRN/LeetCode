class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = indexoflastpeak(nums) - 1;
        if (pivot != -1){
            int nextprefix = lastindexofgreater(nums, nums[pivot]);
            swap(nums, pivot, nextprefix);
        }
        reversesuffix(nums, pivot+1);
    }
    int indexoflastpeak(int nums[] ){
        for (int i = nums.length - 1; 0 < i; --i){
            if (nums[i - 1] < nums[i]) return i;
        }
        return 0;
    }
    int lastindexofgreater(int nums[],int threshold){
        for (int i = nums.length - 1; 0 <= i; --i){
            if(threshold < nums[i]) return i;
        }
        return -1;
    }

    void reversesuffix(int nums[], int start){
        int end = nums.length - 1;
        while (start < end){
            swap(nums, start++, end--);
        }
    }
    void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] =nums[j];
        nums[j] =temp;
    }
}