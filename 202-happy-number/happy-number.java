class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        while (!visit.contains(n)){
            visit.add(n);
            n = getNextNum(n);
            if(n == 1){
                return true;
            }
        }
        return false;
    }
    private int getNextNum(int n){
        int output = 0;
        while (n > 0){
            int digit = n % 10;
            output += digit * digit;
            n = n /10;
        }
        return output;
    }
}