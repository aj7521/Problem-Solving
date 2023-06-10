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
    public boolean isValidBST(TreeNode root) {
        TreeNode min = null;
        TreeNode max = null;
        return isValid(root, min, max);
    }

    public boolean isValid(TreeNode root, TreeNode min, TreeNode max){
        if(root==null) return true;
        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }
        boolean left = isValid(root.left, min, root);
        boolean right = isValid(root.right, root, max);
        return left&right;
    }
}