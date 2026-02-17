class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if num1 == "0" or num2 == "0":
            return "0"
        
        # Result can be at most len(num1) + len(num2) digits
        result = [0] * (len(num1) + len(num2))
        
        # Reverse both strings to work from rightmost digit
        num1 = num1[::-1]
        num2 = num2[::-1]
        
        # Multiply each digit
        for i in range(len(num1)):
            for j in range(len(num2)):
                # Convert chars to integers
                digit1 = ord(num1[i]) - ord('0')
                digit2 = ord(num2[j]) - ord('0')
                
                # Add to the result array at position i+j
                result[i + j] += digit1 * digit2
                
                # Handle carry
                result[i + j + 1] += result[i + j] // 10
                result[i + j] %= 10
        
        # Remove leading zeros
        while len(result) > 1 and result[-1] == 0:
            result.pop()
        
        # Convert back to string (reverse again)
        return ''.join(str(digit) for digit in reversed(result))  