class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        result = []
        # The board is represented as a list where board[row] = column
        board = [-1] * n  # -1 means no queen in that row yet
        
        # Sets to track occupied columns and diagonals
        occupied_cols = set()
        occupied_diag1 = set()  # diagonal from top-left to bottom-right (r - c)
        occupied_diag2 = set()  # diagonal from top-right to bottom-left (r + c)
        
        def backtrack(row):
            # Base case: all rows are filled
            if row == n:
                # Convert board representation to the required format
                solution = []
                for i in range(n):
                    row_str = ['.'] * n
                    row_str[board[i]] = 'Q'
                    solution.append(''.join(row_str))
                result.append(solution)
                return
            
            # Try placing a queen in each column of the current row
            for col in range(n):
                # Check if this position is valid
                diag1 = row - col  # Unique identifier for this diagonal
                diag2 = row + col  # Unique identifier for the other diagonal
                
                if (col not in occupied_cols and 
                    diag1 not in occupied_diag1 and 
                    diag2 not in occupied_diag2):
                    
                    # Place the queen
                    board[row] = col
                    occupied_cols.add(col)
                    occupied_diag1.add(diag1)
                    occupied_diag2.add(diag2)
                    
                    # Recurse to next row
                    backtrack(row + 1)
                    
                    # Remove the queen (backtrack)
                    occupied_cols.remove(col)
                    occupied_diag1.remove(diag1)
                    occupied_diag2.remove(diag2)
        
        # Start backtracking from the first row
        backtrack(0)
        return result