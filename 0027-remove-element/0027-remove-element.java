class Solution {
    public int removeElement(int[] num, int val) {
    int k = 0;
       for(int i = 0 ; i<num.length ; i++){
        if(num[i] != val){
            num[k] = num[i];
            k++;
        }
       } 

       return k;
    }

    public static void main (String args[]){
        Solution solution = new Solution();
        int num[] = {2,1,4,4,5};
        int val = 5;

        int num_length = solution.removeElement(num, val);
        System.out.println(num_length);
        for(int i=0 ; i<num_length; i++){
            System.out.print(num[i]);
        }


    }
}