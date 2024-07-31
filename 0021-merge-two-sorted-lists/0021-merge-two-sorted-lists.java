class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 != null && list2 != null){
           if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
            }
            else{
                list2.next = mergeTwoLists(list1,list2.next);
                return list2;
           }
        }
        if(list1==null)
            return list2;
        return list1;
    }

    public static void main (String args[]){

       
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode ret = new Solution().mergeTwoLists(l1, l2);
        // Print the merged lista
        while (ret != null) {
            System.out.print(ret.val + " ");
            ret = ret.next;
        }

    }
}