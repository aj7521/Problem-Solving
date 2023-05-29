//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
                
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void deletetree( Node root)
{
    if(root == null)
    return;
    deletetree(root.left);
    deletetree(root.right);
    root.left=null;
    root.right=null;
}
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Tree tr=new Tree();
	            ArrayList<Integer> A=new ArrayList<Integer>();
	            tr.serialize(root, A);
	            deletetree(root);
	            root = null;
	            
	            Node getRoot=tr.deSerialize(A);
	            printInorder(getRoot);
	            System.out.println();
	        }
	}
}
// } Driver Code Ends


/*Complete the given function
Node is as follows:
class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}*/

class Tree 
{
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    //code here
	    if(root==null) return;
	    Queue<Node> q = new LinkedList<>();
	    q.offer(root);
        A.add(root.data);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                Node node = q.poll();
                
                if(node.left==null)
                {
                    A.add(-1);
                }
                if(node.left!=null)
                {
                    q.offer(node.left);
                    A.add(node.left.data);
                }
                if(node.right==null)
                {
                    A.add(-1);
                }
                if(node.right!=null)
                {
                    q.offer(node.right);
                    A.add(node.right.data);
                }
            }
        }
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        int rootVal = A.get(0);
        if(rootVal==-1) return null;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(rootVal);
        q.offer(root);    
        for(int i=1; i<A.size()-1; i++)
        {
            Node cur = q.poll();
            if(A.get(i)!=-1)
            {
                int val = A.get(i);
                cur.left = new Node(val);
                q.offer(cur.left);
            }
            if(A.get(++i)!=-1)
            {
                int val2 = A.get(i);
                cur.right = new Node(val2);
                q.offer(cur.right);
            }
        }
        return root;
    }
};