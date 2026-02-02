class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
            
        # First, find the correct row
        top, bottom = 0, len(matrix) - 1
        while top <= bottom:
            row_mid = (top + bottom) // 2
            if matrix[row_mid][0] <= target <= matrix[row_mid][-1]:
                # Found the row, now search within it
                left, right = 0, len(matrix[0]) - 1
                while left <= right:
                    col_mid = (left + right) // 2
                    if matrix[row_mid][col_mid] == target:
                        return True
                    elif matrix[row_mid][col_mid] < target:
                        left = col_mid + 1
                    else:
                        right = col_mid - 1
                return False
            elif matrix[row_mid][0] > target:
                bottom = row_mid - 1
            else:  # matrix[row_mid][-1] < target
                top = row_mid + 1
                
        return False
        