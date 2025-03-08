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
    private int i = 0;
    private int p = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
        
    }
    private TreeNode build (int pre[], int ino [], int stop){
        if (p >= pre.length){
            return null;
        }
        if (ino [i] == stop){
            ++i;
            return null;
        }
        TreeNode node = new TreeNode (pre[p++]);
        node.left = build (pre, ino, node.val);
        node.right = build (pre, ino, stop);
        return node;
    }
}