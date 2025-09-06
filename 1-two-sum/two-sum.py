class Solution(object):
    def twoSum(self, nums, target):
        num_idx = {}
        for i,num in enumerate(nums):
            compler = target - num
            if compler in num_idx:
                return [num_idx[compler],i]
            num_idx[num]=i    
        return[]
        