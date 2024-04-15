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

    public TreeNode convertBST(TreeNode root) {
        sum(root, 0);
        return root;
    }
    public int sum(TreeNode root, int sum) {

        if (root == null) return 0;

        int right = sum(root.right, sum);

        if (right == 0) {
            sum = root.val + sum;
        } else {
            sum = root.val + right;
        }

        root.val = sum;     

        int left = sum(root.left, sum);
        return left == 0 ? sum : left;
        
    }
}