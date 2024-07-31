class Solution {
    public static int lengthOfLongestSubstring(String s) {
     HashSet<Character> set = new HashSet<>();
     int maxlength = 0, left = 0;
     for(int i = 0; i< s.length(); i++){
        while(set.contains(s.charAt(i))){
            set.remove(s.charAt(left));
            left++;
        }
        set.add(s.charAt(i));
        maxlength = Math.max(maxlength, i - left + 1);
     }  
     return maxlength;

    }
    public static void main(String args[]){
        String s = "pwwkew";
        System.out.print(lengthOfLongestSubstring(s) );
    }
}