class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
      int n = s.length();
        int[] shiftAmounts = new int[n + 1]; // To store net shifts for each index

        // Step 1: Accumulate shifts in the `shiftAmounts` array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            // Add or subtract shifts based on the direction
            shiftAmounts[start] += (direction == 1) ? 1 : -1;
            shiftAmounts[end + 1] += (direction == 1) ? -1 : 1; // Undo after `end`
        }

        // Step 2: Compute cumulative shifts
        int cumulativeShift = 0;
        for (int i = 0; i < n; i++) {
            cumulativeShift += shiftAmounts[i];
            shiftAmounts[i] = cumulativeShift; // Store cumulative shift at index i
        }

        // Step 3: Apply the cumulative shifts to the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int originalChar = s.charAt(i) - 'a'; // Convert to 0-25 range
            int shiftedChar = (originalChar + shiftAmounts[i]) % 26; // Handle wrapping
            if (shiftedChar < 0) shiftedChar += 26; // Handle negative wrapping
            result.append((char) ('a' + shiftedChar)); // Convert back to character
        }

        return result.toString();  
    }
}

