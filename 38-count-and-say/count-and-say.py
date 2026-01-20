class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n == 1:
            return "1"
        
        # Get the previous term recursively
        prev = self.countAndSay(n - 1)
        
        # Perform run-length encoding on prev
        result = ""
        count = 1
        
        for i in range(len(prev)):
            if i == len(prev) - 1 or prev[i] != prev[i + 1]:
                result += str(count) + prev[i]
                count = 1
            else:
                count += 1
        
        return result