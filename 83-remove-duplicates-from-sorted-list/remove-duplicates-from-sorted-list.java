/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        ListNode temp2 = head.next;
        int last = head.val;
        while(temp2 != null){
            if(temp2.val == last){
               if(temp2.next == null){
                  temp.next = null;
                  break;
               }
               temp2 = temp2.next;
               temp.next = temp2;
            }
            else{
                temp = temp2;
                last = temp.val;
                temp2 = temp2.next;
            }
        }
        return head;
    }
    public static void main (String args[]){

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
    
        Solution remover = new Solution();
        ListNode result = remover.deleteDuplicates(head);

        // Print the result
        printList(result);
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}