/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        if(node==null) return node;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while(!q.isEmpty()){
            Node temp = q.poll();
            for(Node i: temp.neighbors){
                if(!map.containsKey(i)){
                    q.offer(i);
                    map.put(i, new Node(i.val, new ArrayList<>()));
                }
                map.get(temp).neighbors.add(map.get(i));
            }
        }
        return map.get(node);
    }
}