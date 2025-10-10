class Solution(object):
    def longestSubstring(self, s, k):
         # Base case: if string is shorter than k, impossible to have any character appear k times
        if len(s) < k:
            return 0
        
        # Count frequency of all characters in current substring
        char_count = {}
        for char in s:
            char_count[char] = char_count.get(char, 0) + 1
        
        # Find the first character that appears less than k times
        for i, char in enumerate(s):
            if char_count[char] < k:
                # Split on this character and recursively check left and right parts
                left_part = self.longestSubstring(s[:i], k)
                right_part = self.longestSubstring(s[i+1:], k)
                return max(left_part, right_part)
        
        # If we reach here, all characters in current substring appear at least k times
        return len(s)
        