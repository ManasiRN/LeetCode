class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        # Create a list of available numbers
        numbers = [str(i) for i in range(1, n + 1)]
        
        # Precompute factorials
        factorial = [1] * (n + 1)
        for i in range(1, n + 1):
            factorial[i] = factorial[i - 1] * i
        
        # Adjust k to be 0-indexed
        k -= 1
        
        result = []
        
        # Build the permutation digit by digit
        for i in range(n, 0, -1):
            # Determine which block we're in
            block_size = factorial[i - 1]
            index = k // block_size
            
            # Add the number at that index to the result
            result.append(numbers[index])
            
            # Remove the used number
            numbers.pop(index)
            
            # Update k for the next iteration
            k %= block_size
        
        return ''.join(result)