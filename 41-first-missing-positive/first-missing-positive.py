class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        
        # Step 1: Replace negative numbers and zeros with (n+1)
        # We use n+1 because it's outside our range of interest [1, n]
        for i in range(n):
            if nums[i] <= 0 or nums[i] > n:
                nums[i] = n + 1
        
        # Step 2: Use index marking to indicate presence of numbers
        # For each number x in [1, n], mark position x-1 as visited
        for i in range(n):
            num = abs(nums[i])  # Take absolute value since we might have marked some as negative
            if num <= n:  # Only process numbers in range [1, n]
                idx = num - 1  # Convert number to 0-based index
                if nums[idx] > 0:  # Mark only if not already marked
                    nums[idx] = -nums[idx]  # Mark as negative to indicate presence
        
        # Step 3: Find the first positive number
        # The first index i where nums[i] > 0 means number (i+1) is missing
        for i in range(n):
            if nums[i] > 0:
                return i + 1
        
        # If all positions [0, n-1] are marked, answer is n+1
        return n + 1