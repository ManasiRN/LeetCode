class Solution {
    public String longestPalindrome(String s) {
        // If the input string is null or empty, return an empty string
        if (s == null || s.length() == 0) {
            return "";
        }

        // Initialize start and end indices for the longest palindromic substring
        int start = 0, end = 0;

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Check for the longest odd-length palindrome centered at i
            int len1 = expandAroundCenter(s, i, i);
            // Check for the longest even-length palindrome centered between i and i+1
            int len2 = expandAroundCenter(s, i, i + 1);

            // Find the maximum length of palindrome found
            int len = Math.max(len1, len2);

            // If the found palindrome length is greater than the previously recorded length
            if (len > end - start) {
                // Update the start and end indices based on the new length
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // Expand around the center while the characters on both sides are equal
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Return the length of the palindrome found
        // right - left - 1 accounts for the last decrement/increment before the condition fails
        return right - left - 1;
    }
}