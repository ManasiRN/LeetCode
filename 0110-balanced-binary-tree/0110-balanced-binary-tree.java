/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedAndHeight(root) >= 0;
    }

    public int isBalancedAndHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = isBalancedAndHeight(root.left);
        if (l < 0) {
            return l;
        }
        int r = isBalancedAndHeight(root.right);
        if (r < 0) {
            return r;
        }
        if (Math.abs(l-r) > 1) { 
            return -Math.abs(l-r);
        }
        return Math.max(l, r) + 1;
    }

}