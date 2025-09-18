# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        if not root:
            return None

        if root == p or root == q:
            return root

        left_result = self.lowestCommonAncestor(root.left, p, q)
        right_result = self.lowestCommonAncestor(root.right, p, q) 

        if left_result and right_result:
            return root

        if left_result:
            return left_result

        if right_result:
            return right_result

        return None                   
        
        