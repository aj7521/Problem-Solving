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
    public int maxLevelSum(TreeNode root) {
        int max = root.val;
        int ind = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int curInd = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            curInd++;
            for(int i=0; i<size; i++){
                TreeNode temp = q.poll();
                sum += temp.val;
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            if(sum > max){
                max = sum;
                ind = curInd;
            }
        }
        return ind;
    }
}