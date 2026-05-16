class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result = []
        
        def backtrack(current, open_count, close_count):
            # Base case: if we've used all opening and closing parentheses
            if open_count == n and close_count == n:
                result.append(current)
                return
            
            # Add an opening parenthesis if we haven't used all of them
            if open_count < n:
                backtrack(current + '(', open_count + 1, close_count)
            
            # Add a closing parenthesis if we can (have more opens than closes)
            if close_count < open_count:
                backtrack(current + ')', open_count, close_count + 1)
        
        backtrack('', 0, 0)
        return result