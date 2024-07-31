class Solution {
    public static boolean isPalindrome(int num) {
      int res=0, copy=num;
      while(num>0){
        int rem= num%10;
        res=(res*10)+rem;
        num/=10;
      }
      if(res==copy){
        return true;
      }
      else{
        return false;
      }
    }
    public static void main (String args[]){
       int  num=121;
       isPalindrome(num);

    }
}