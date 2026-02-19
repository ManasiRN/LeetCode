class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def backtrack(path, used):
            # If we've built a complete permutation
            if len(path) == len(nums):
                result.append(path[:])
                return
            
            # Try placing each unused number at the current position
            for i in range(len(nums)):
                # Skip if the number is already used
                if used[i]:
                    continue
                
                # Skip duplicates: if current number equals previous number 
                # and previous number hasn't been used in this branch
                if i > 0 and nums[i] == nums[i-1] and not used[i-1]:
                    continue
                
                # Add current number to path
                used[i] = True
                path.append(nums[i])
                
                # Recurse
                backtrack(path, used)
                
                # Backtrack
                path.pop()
                used[i] = False
        
        # Sort to handle duplicates efficiently
        nums.sort()
        result = []
        used = [False] * len(nums)
        backtrack([], used)
        return result