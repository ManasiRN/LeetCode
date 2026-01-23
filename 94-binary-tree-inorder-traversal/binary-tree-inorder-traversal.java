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
    public ArrayList<Integer> list;
    
    
    public void fun(TreeNode root){
        if(root == null){
            return ;
        }
        fun(root.left);
        list.add(root.val);
        fun(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        fun(root);
        return list;
    }

    public static void main(String[] args) {
        // Creating a simple binary tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Creating an instance of Solution and calling inorderTraversal
        Solution solution = new Solution();
        List<Integer> result = solution.inorderTraversal(root);

        // Printing the result
        System.out.println(result); // Output should be [1, 3, 2]
    }
}