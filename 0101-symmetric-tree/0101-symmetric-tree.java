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
    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isMirror (root.left, root.right);
    }
    public static boolean isMirror (TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }
        return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right,node2.left);
    }
    public static void main (String args[]){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);

        System.out.println(isSymmetric(tree));  

    }
}