class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        # Initialize the matrix with zeros
        matrix = [[0] * n for _ in range(n)]
        
        # Define boundaries
        top, bottom = 0, n - 1
        left, right = 0, n - 1
        
        num = 1  # Start filling from 1
        
        while top <= bottom and left <= right:
            # Fill top row from left to right
            for i in range(left, right + 1):
                matrix[top][i] = num
                num += 1
            top += 1
            
            # Fill right column from top to bottom
            for i in range(top, bottom + 1):
                matrix[i][right] = num
                num += 1
            right -= 1
            
            # Fill bottom row from right to left (if still valid)
            if top <= bottom:
                for i in range(right, left - 1, -1):
                    matrix[bottom][i] = num
                    num += 1
                bottom -= 1
            
            # Fill left column from bottom to top (if still valid)
            if left <= right:
                for i in range(bottom, top - 1, -1):
                    matrix[i][left] = num
                    num += 1
                left += 1
        
        return matrix