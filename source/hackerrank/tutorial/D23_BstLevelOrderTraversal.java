package source.hackerrank.tutorial;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}

class D23_BstLevelOrderTraversal{

    static void levelOrder(Node root) {
        //Write your code here
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        String result = "";
    
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            result += " " + current.data;
            
            if (current.left != null) {
                queue.add(current.left);
            }
            
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    
        System.out.println(result.substring(1));
    }

    public static Node insert(Node root,int data){
        if(root==null) {
            return new Node(data);
        } else {
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner scanner =new Scanner(System.in);
            int T = scanner.nextInt();
            Node root=null;
            while(T-->0){
                int data = scanner.nextInt();
                root=insert(root,data);
            }
            scanner.close();
            
            levelOrder(root);
        }	
}
