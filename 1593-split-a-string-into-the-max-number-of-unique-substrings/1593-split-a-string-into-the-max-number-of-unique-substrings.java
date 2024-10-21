import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, Set<String> uniqueSubstrings) {
        // Base case: if we've processed the entire string
        if (start == s.length()) {
            return uniqueSubstrings.size();
        }

        int maxSplits = 0;
        // Try every possible split starting from 'start' index
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!uniqueSubstrings.contains(substring)) {
                // Add the substring to the set and continue
                uniqueSubstrings.add(substring);
                maxSplits = Math.max(maxSplits, backtrack(s, end, uniqueSubstrings));
                // Backtrack: remove the substring from the set
                uniqueSubstrings.remove(substring);
            }
        }
        
        return maxSplits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ababccc";
        System.out.println(solution.maxUniqueSplit(s));  // Output: 5
    }
}
