class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int Odd = 0, even = 1;
        int result = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (sum % 2 == 1){
                result = (result + even) % MOD;
                Odd++;
            } else {
                result = (result + Odd) % MOD;
                even++;
            }
        }
        return result;
    }
}