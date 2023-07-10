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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int ans = miniDepth(root);
        return ans;
    }
    public int miniDepth(TreeNode root){
        if(root==null) return -1;
        if(root.left==null && root.right==null){
            return 1;
        }
        int left = 1 + miniDepth(root.left);
        int right = 1 + miniDepth(root.right);
        if(left==0) return right;
        if(right==0) return left;
        return Math.min(left, right);
    }
}