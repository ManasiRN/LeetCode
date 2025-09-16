"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution(object):
    def connect(self, root):
        if not root:
            return None
        
        current = root
        
        while current:
            dummy = Node(0)  # Dummy node to start the next level
            tail = dummy      # Tail pointer to build the linked list
            
            # Process all nodes in current level
            while current:
                if current.left:
                    tail.next = current.left
                    tail = tail.next
                if current.right:
                    tail.next = current.right
                    tail = tail.next
                current = current.next
            
            # Move to the next level
            current = dummy.next
        
        return root