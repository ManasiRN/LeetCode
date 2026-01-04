class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int result[] = merging(nums1,nums2);
        int reslength = result.length;

        if (reslength % 2 == 0){
            return (result[reslength / 2-1] + result[reslength / 2])/ 2.0;
        }else{
            return result[reslength / 2];
        }
    }

    public static int[] merging(int [] nums1, int [] nums2){
        int result [] = new int[nums1.length + nums2.length];
        int counter = 0;
        int indx1 = 0;
        int indx2 = 0;

        while(indx1 < nums1.length || indx2 < nums2.length){
            if(indx2 < nums2.length && (indx1 >= nums1.length || nums1[indx1] > nums2[indx2]))
            {
                result[counter++] = nums2[indx2++];
            }
            else{
                result[counter++] = nums1[indx1++];
            }
        }
        return result;
    }
    public static void main (String args[]){
        int [] nums1 = {1,3};
        int [] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
