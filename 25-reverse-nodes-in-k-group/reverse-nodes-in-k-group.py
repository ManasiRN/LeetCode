class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: Optional[ListNode]
        :type k: int
        :rtype: Optional[ListNode]
        """
        # Create a dummy node to simplify edge cases
        dummy = ListNode(0)
        dummy.next = head
        
        # prev tracks the end of the previous group
        prev = dummy
        
        while True:
            # Check if we have at least k nodes left
            kth = self.getKth(prev, k)
            if not kth:
                break  # Not enough nodes left
            
            # Save the start of next group
            next_group = kth.next
            
            # Reverse the current group
            current = prev.next  # First node in current group
            reverse_prev = next_group  # Start reversal pointing to next group
            
            # Reverse k nodes
            for _ in range(k):
                temp = current.next
                current.next = reverse_prev
                reverse_prev = current
                current = temp
            
            # Connect previous group to reversed group
            temp = prev.next  # Old first node (now last)
            prev.next = kth   # Connect to new first node
            prev = temp       # Move to end of current group
        
        return dummy.next
    
    def getKth(self, node, k):
        # Move k steps forward from node
        current = node
        for i in range(k):
            if not current:
                return None
            current = current.next
        return current