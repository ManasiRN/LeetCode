class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        # Constants for 32-bit signed integer range
        INT_MAX = 2**31 - 1   # 2147483647
        INT_MIN = -2**31      # -2147483648
        
        # Special case: Only overflow scenario
        # If we divide INT_MIN by -1, result would be 2^31 which exceeds INT_MAX
        if dividend == INT_MIN and divisor == -1:
            return INT_MAX
        
        # Determine the sign of the result
        # Result is negative if dividend and divisor have opposite signs
        negative = (dividend < 0) != (divisor < 0)
        
        # Convert both numbers to negative to avoid overflow issues
        # Why negative? Because abs(INT_MIN) = 2147483648 > INT_MAX = 2147483647
        # Working with negatives ensures we can handle INT_MIN correctly
        if dividend > 0:
            dividend = -dividend
        if divisor > 0:
            divisor = -divisor
        
        # Initialize quotient to 0
        quotient = 0
        
        # Core division logic
        # Since both are negative: while dividend <= divisor
        # (For positives: while dividend >= divisor)
        while dividend <= divisor:
            # Find the largest multiple of divisor that fits into dividend
            # We'll try to double divisor repeatedly
            power_of_two = 1
            value = divisor
            
            # Check if we can double value without exceeding dividend
            # For negatives: value >= dividend - value
            # This is equivalent to: 2*value >= dividend for positives
            # We need to be careful with overflow, so we don't multiply directly
            while value >= dividend - value:
                # Double the value (like left shift << 1)
                value += value
                # Double the corresponding power of two
                power_of_two += power_of_two
            
            # Subtract the largest doubled divisor from dividend
            dividend -= value
            # Add the corresponding power of two to quotient
            quotient += power_of_two
        
        # Apply the correct sign to the result
        if negative:
            quotient = -quotient
        
        # Clamp the result to 32-bit integer range
        # (Though our logic should already respect this)
        if quotient > INT_MAX:
            return INT_MAX
        if quotient < INT_MIN:
            return INT_MIN
        
        return quotient