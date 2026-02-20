class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def findLeftmost(nums, target):
            left, right = 0, len(nums) - 1
            leftmost = -1
            
            while left <= right:
                mid = left + (right - left) // 2
                
                if nums[mid] == target:
                    leftmost = mid
                    right = mid - 1  # Continue searching in left half
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            
            return leftmost
        
        def findRightmost(nums, target):
            left, right = 0, len(nums) - 1
            rightmost = -1
            
            while left <= right:
                mid = left + (right - left) // 2
                
                if nums[mid] == target:
                    rightmost = mid
                    left = mid + 1  # Continue searching in right half
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            
            return rightmost
        
        leftmost = findLeftmost(nums, target)
        
        # If target not found in leftmost search, it doesn't exist in the array
        if leftmost == -1:
            return [-1, -1]
        
        rightmost = findRightmost(nums, target)
        
        return [leftmost, rightmost]