package source.hackerrank.tutorial;

import java.util.Scanner;

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class BinarySearchTree {

	public static int getHeight(Node root){
      //Write your code here
      int rightHeight = 0;
      int leftHeight = 0;
      if (root.left != null) {
          leftHeight = getHeight(root.left) + 1;
      }
      if (root.right != null) {
          rightHeight = getHeight(root.right) + 1;
      }
      int result = (rightHeight > leftHeight? rightHeight : leftHeight);
      return result;
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
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
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}
