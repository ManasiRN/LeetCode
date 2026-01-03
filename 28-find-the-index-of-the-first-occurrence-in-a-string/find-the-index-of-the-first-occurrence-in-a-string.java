class Solution {
    public static int strStr(String haystack, String needle) {
         if (needle.isEmpty()) {
            return 0;
        }
         int h = haystack.length();
         int n = needle.length();

         if(n == 0){
            return 0;
         }
        

         for(int i = 0; i <= h-n; i++){
            if (haystack.substring(i,i+n).equals(needle)){
                return i;
            }
         }
         return -1;

    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        String haystack = "hello";
        String needle = "ll";
        
        int result = solution.strStr(haystack, needle);
        System.out.println("The first occurrence of needle in haystack is at index: " + result);
        
        haystack = "aaaaa";
        needle = "bba";
        
        result = solution.strStr(haystack, needle);
        System.out.println("The first occurrence of needle in haystack is at index: " + result);
        
        haystack = "";
        needle = "";
        
        result = solution.strStr(haystack, needle);
        System.out.println("The first occurrence of needle in haystack is at index: " + result);
}
}