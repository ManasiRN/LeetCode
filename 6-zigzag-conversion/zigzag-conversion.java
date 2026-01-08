import java.util.Vector;

class Solution {
    public String convert(String s, int numRows) {
        // Handle the edge case when only one row is needed
        if (numRows == 1) {
            return s;
        }
        
        // Initialize a vector of strings to hold the characters for each row
        Vector<String> ans = new Vector<>(numRows);
        for (int j = 0; j < numRows; j++) {
            ans.add(""); // Initialize each row with an empty string
        }

        // Variables to control the direction of zigzag
        boolean flag = false; // True for down, False for up
        int i = 0; // The current row index

        // Traverse each character of the input string
        for (char ch : s.toCharArray()) {
            ans.set(i, ans.get(i) + ch); // Append character to the current row
            if (i == 0 || i == numRows - 1) {
                flag = !flag; // Change direction
            }
            i += (flag ? 1 : -1); // Move up or down
        }

        // Build the final zigzag string by concatenating all rows
        String zigzag = "";
        for (String str : ans) {
            zigzag += str;
        }

        return zigzag;
    }
}
