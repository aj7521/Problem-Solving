/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root==null || target==null){
            return ans;
        }
        Map<TreeNode, TreeNode> par = new HashMap<>();
        Map<TreeNode, Boolean> vis = new HashMap<>();
        markPar(root, par, vis);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        while(!q.isEmpty() && k>0){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                vis.put(node, false);
                if(node.left!=null && vis.get(node.left)==true){
                    q.offer(node.left);
                }
                if(node.right!=null && vis.get(node.right)==true){
                    q.offer(node.right);
                }
                TreeNode parent = par.get(node);
                if(parent!=null && vis.get(parent)==true){
                    q.offer(parent);
                }
            }
            k--;
        }

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }

    public void markPar(TreeNode root, Map<TreeNode, TreeNode> par, Map<TreeNode, Boolean> vis){
        par.put(root, null);
        vis.put(root, true);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                vis.put(node, true);
                if(node.left!=null){
                    q.offer(node.left);
                    par.put(node.left, node);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    par.put(node.right, node);
                }
            }
        }
        return;
    }
}