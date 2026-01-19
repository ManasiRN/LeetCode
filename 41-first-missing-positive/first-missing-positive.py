class Solution(object):
    def firstMissingPositive(self, nums):
        n = len(nums)
        
        # Place each number in its correct position if possible
        for i in range(n):
            # Keep swapping until nums[i] is in its correct position or can't be placed
            while 1 <= nums[i] <= n and nums[nums[i] - 1] != nums[i]:
                # Swap nums[i] with nums[nums[i] - 1]
                correct_idx = nums[i] - 1
                nums[i], nums[correct_idx] = nums[correct_idx], nums[i]
        
        # Find first missing positive
        for i in range(n):
            if nums[i] != i + 1:
                return i + 1
        
        return n + 1