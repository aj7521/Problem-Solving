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
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> inorder = new ArrayList<>();
        int minVal = Integer.MAX_VALUE;
        while(true){
            if(root!=null){
                st.push(root);
                root = root.left;
            }
            else
            {
                if(st.isEmpty()){
                    break;
                }
                root = st.pop();
                inorder.add(root.val);
                root = root.right;
            }
        }
        for(int i=1; i<inorder.size(); i++){
            minVal = Math.min(minVal, inorder.get(i) - inorder.get(i-1));
        }
        return minVal;
    }
}