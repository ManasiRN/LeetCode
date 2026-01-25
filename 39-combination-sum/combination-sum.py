class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def backtrack(start, path, current_sum):
            # If we've reached exactly the target, add a copy of the path to results
            if current_sum == target:
                result.append(path[:])  # Make a copy of path
                return
            # If we've exceeded the target, stop exploring this path
            if current_sum > target:
                return
            
            # Try each candidate starting from 'start' index
            for i in range(start, len(candidates)):
                # Choose: add current candidate to path
                path.append(candidates[i])
                # Explore: recurse with same index to allow reuse
                backtrack(i, path, current_sum + candidates[i])
                # Unchoose: remove last element (backtrack)
                path.pop()
        
        result = []
        # Start backtracking from index 0 with empty path and sum 0
        backtrack(0, [], 0)
        return result