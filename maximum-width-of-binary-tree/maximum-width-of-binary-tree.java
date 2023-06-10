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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int max = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = 0, mx = 0;
            for(int i=0; i<size; i++){
                Pair temp = q.poll();
                TreeNode node = temp.node;
                int par = temp.par;
                if(i==0) min = par;
                if(i==size-1) mx = par;
                if(node.left!=null){
                    q.offer(new Pair(node.left, par*2));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right, par*2+1));
                }
            }
            max = Math.max(max, mx-min);
        }
        return max+1;
    }
}

class Pair{
    TreeNode node;
    int par;
    Pair(TreeNode n, int p){
        node = n;
        par = p;
    }
}