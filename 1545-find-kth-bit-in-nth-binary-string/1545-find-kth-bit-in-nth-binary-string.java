class Solution {
    public String findstr(int n) {
        if (n == 1) return "0";
        
        String s = findstr(n - 1);
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ans = new StringBuilder();
        
        // Add the original string and '1'
        ans.append(s).append('1');
        
        // Invert the characters of s and append the reverse
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                sb.setCharAt(i, '0');
            } else {
                sb.setCharAt(i, '1');
            }
        }
        
        // Reverse the inverted string and append it
        ans.append(sb.reverse());
        
        return ans.toString();
    }

    public char findKthBit(int n, int k) {
        String s = findstr(n);
        return s.charAt(k - 1);
    }
}
