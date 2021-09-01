package codes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {
	//5 5 20 3 -1 18 80 -1 -1 16 -1 -1 -1 -1 -1

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree root = buildTree();
		//inorder(root);
		//search(root,9);
		//BinaryTree root1 = insert(root,2);
		//inorder(root1);
		
		//int ans = floor(root,100);
		int ans = ceil(root,14);
		System.out.println(ans);
		//TODO Write code for deletion code

	}
	
	public static int floor(BinaryTree root,int n) {
		int floor = 0;
		
		while(root!=null) {
			if(root.data <= n && root.data>floor)
				floor = root.data;
			if(n<=root.data)
				root=root.left;
			else
				root=root.right;
			
		}
		
		return floor;
	}
	
	public static int ceil(BinaryTree root,int n) {
		int ceil = Integer.MAX_VALUE;
		
		while(root!=null) {
			if(root.data >= n && root.data<ceil)
				ceil = root.data;
			if(n<=root.data)
				root=root.left;
			else
				root=root.right;
			
		}
		
		return ceil;
	}
	public static BinaryTree insert(BinaryTree root,int n) {
		BinaryTree temp=new BinaryTree(n);
		if(root==null) {
			return temp;
		}
		BinaryTree curr=root;
		BinaryTree parent=root;
		while(curr!=null) {
			parent=curr;
		   if(n>curr.data) {
		    	curr=curr.right;
		    }
		   else if(n<curr.data)
			   curr=curr.left;	    
		}
		
		if(parent.data>n)
			parent.left=temp;
		else if(parent.data<n)
			parent.right=temp;
		
		return root;
	}
	
	public static void search(BinaryTree root,int n) {
		boolean ans = false;
		
		while(root!=null) {
		   if(root.data==n) {
			ans = true;
			break;
		   }
		else if(n>root.data)
			root=root.right;
		else
			 root=root.left;
		}
		
		System.out.println(ans);
	}
	
	public static void inorder(BinaryTree root) {
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	
	public static BinaryTree buildTree() {
		Scanner s = new Scanner(System.in);
		System.out.println("enter root");
		int rootData = s.nextInt();
		Queue<BinaryTree> q = new LinkedList<>();
		BinaryTree root = new BinaryTree(rootData);
		q.add(root);
		
		while(!q.isEmpty()) {
			BinaryTree curr = q.poll();
			//System.out.println("enter left child for "+curr.data);
			int leftChild = s.nextInt();
			//System.out.println("enter right child for "+curr.data);
			int rightChild = s.nextInt();
			
			if(leftChild!=-1) {
				curr.left=new BinaryTree(leftChild);
				q.add(curr.left);
			}
			if(rightChild!=-1) {
				curr.right=new BinaryTree(rightChild);
				q.add(curr.right);
			}
		
		}
		
		return root;
	}

}
