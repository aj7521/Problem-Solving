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
    public List<List<String>> printTree(TreeNode root) {
        int m = findHeight(root);
        int n = (int)Math.pow(2, m) - 1;
        int arr[][] = new int[m][n];
        for(int[] a: arr){
            Arrays.fill(a, (int)(-1e8));
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0, n));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int row = p.r;
                int l = p.l;
                int h = p.h;
                int mid = l + (h-l)/2;
                arr[row][mid] = node.val;
                if(node.left!=null) q.offer(new Pair(node.left, row+1, l, mid));
                if(node.right!=null) q.offer(new Pair(node.right, row+1, mid, h));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<m; i++){
            List<String> temp = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(arr[i][j]==(int)(-1e8)){
                    temp.add("");
                }
                else{
                    temp.add(String.valueOf(arr[i][j]));
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public int findHeight(TreeNode root){
        if(root==null) return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return 1 + Math.max(left, right);
    }
}
class Pair{
    TreeNode node;
    int r;
    int l;
    int h;
    Pair(TreeNode n, int row, int lw, int rw){
        node = n;
        r = row;
        l = lw;
        h = rw;
    }
}