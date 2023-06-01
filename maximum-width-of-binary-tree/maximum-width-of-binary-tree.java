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
        Queue<Pair> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int st = 0, en = 0;
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                TreeNode temp = p.node;
                int par = p.par;
                if(i==0){
                    st = par;
                }
                if(i==size-1) en = par;
                if(temp.left!=null){
                    q.offer(new Pair(temp.left, 2*par));
                }
                if(temp.right!=null){
                    q.offer(new Pair(temp.right, 2*par+1));
                }
            }
            max = Math.max(max, en-st+1);
        }
        return max;
    }
}

class Pair{
    TreeNode node;
    int par;
    Pair(TreeNode tn, int p){
        node = tn;
        par = p;
    }
}