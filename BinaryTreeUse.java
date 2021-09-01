package codes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTreeUse {
	
	static int maxLevel=0;
	static int preorder=0;
  
	public static void main(String[] args) {
		int ans=0;
		//BinaryTree root = buildTree();
		//BinaryTree root1 = buildTree();
		//inorderTraversal(root);
		//preorderTraversal(root);
		//postorderTraversal(root);
		
		//System.out.println(heightOfTree(root));
		
		//TO print nodes at Kth level from root 
		//kLevelNodes(root, 2);
		
		//Level order Traversal
		//BFS(root); //TODO Use Queue inbuilt Data structure
		
		//leftTreeView(root, 1);
		
		//ans = treeSize(root);
		
		//ans = maxValue(root);
		
		 // ans = maxWidth(root);
		
		//System.out.println(childSumTree(root));
	    
	    //System.out.println(balancedTree(root));
		  
		  //Building a complete tree from inorder and preorder array
		  
		  //buildTree(in,pre,is,ie);
	    
	       //spiralTraversal(root);
		
		  //ans = diameter(root);
	    
	     //BinaryTree lca = LCA(root,1,4);
		  

		  //System.out.println(lca.data);
	    
	     // ans = sizeOfTree(root);
		
	     // System.out.println(ans);
		
		 //System.out.println(isSubtree(root,root1));
		
		//connect(root);
		
		ArrayList<String> names= new ArrayList<>();
		names.add("prachi");
		names.add("lakshya");
		names.add("acd");
		names.add("abc");
		names.add("b");
		
		Collections.sort(names,Collections.reverseOrder());
		
		for(String s:names){
			System.out.println(s);
		}
	    
	    
	}
	
//	public static void createTree(int[] arr,int n) {
//		HashMap<Integer,BinaryTree> set = new HashMap<>();
//        
//        for(int i=0;i<n;i++){
//            
//                set.put(arr[i],new BinaryTree(i));
//        }
//        
//        for(int i=0;i<n;i++){
//            
//            if(set.containsKey()){
//                BinaryTree temp = set.get(key)
//                if(temp.left!=null)
//                  temp.left=set.(i);
//            }
//        }   
//	}
	
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
	
	public static void connect(BinaryTree root) {
		 // Your code goes here.
        Queue<BinaryTree> q = new LinkedList<>();
        BinaryTree curr = null;
        q.add(root);
        
        while(!q.isEmpty()){
            int count = q.size();
            for(int i=0;i<count;i++){
                curr = q.poll();
                if(q.peek()!=null)
                curr.nextRight=q.peek();
                
                if(curr.left!=null)
                q.add(curr.right);
                if(curr.right!=null)
                q.add(curr.left);
            }
            
            curr.nextRight = null;
        }
	}
	
	 public static boolean isSubtree(BinaryTree T, BinaryTree S) {
	        // add code here.
	        if(T==null)
	        return false;
	        if(T.data == S.data){
	        	boolean temp = isEqual(T,S);
	        	boolean templ = isSubtree(T.left,S);
	            boolean tempr = isSubtree(T.right,S);   
	            
	            if(temp)
	            	return temp;
	            	else if(templ)
	            		return templ;
	            	else if(tempr)
	            		return tempr;
	            	else
	            		return false;
	            
	        }
	        
	        boolean left = isSubtree(T.left,S);
	        boolean right = isSubtree(T.right,S);
	        
	        if(left == true)
	        return left;
	        else
	        return right;
	        
	    }
	    
	    public static boolean isEqual(BinaryTree r1, BinaryTree r2){
	        if(r1 == null && r2 == null){
	            return true;
	        }
	        
	        else if((r1==null && r2!=null) || (r1!=null && r2==null)){
	            return false;
	        }
	        
	        return r1.data==r2.data && isEqual(r1.left,r2.left) && isEqual(r1.right,r2.right);
	    }
	
	public static int leftHeight(BinaryTree root) {
		if(root == null)
			return 0;
		
		return leftHeight(root.left)+1;
	}
	
	public static int rightHeight(BinaryTree root) {
		if(root == null)
			return 0;
		
		return rightHeight(root.right)+1;
	}
	
	
	//Size of complete binary tree
	public static int sizeOfTree(BinaryTree root) {
		if(root==null) {
			return 0;
		}
		
		int lh = leftHeight(root.left)+1;
		int rh = rightHeight(root.right)+1;
		
		if(lh==rh) {
			return (int)Math.pow(2,lh)-1;
		}
		
		return sizeOfTree(root.left)+sizeOfTree(root.right)+1;
	}
	
	public static BinaryTree LCA(BinaryTree root,int n1,int n2) {
		if(root == null)
			return null;
		
		if(root.data == n1 || root.data ==n2) {
			return root;
		}
		
		
		BinaryTree lca = LCA(root.left,n1,n2);
		BinaryTree rca = LCA(root.right,n1,n2);
		
		if(lca!=null && rca!=null) {
			return root;
		}
		
		if(lca!=null)
			return lca;
		
		else
			return rca;
	}
	
	//TODO write O(n) solution
	public static int diameter(BinaryTree root) {
		int ans=0;
		if(root == null) {
			return 0;
		}
		
		ans = heightOfTree(root.left)+heightOfTree(root.right)+1;
		
		return Math.max(ans,Math.max(diameter(root.left), diameter(root.right)));
		
		
	}
	
	public static void spiralTraversal(BinaryTree root) {
		
		Queue<BinaryTree> q = new LinkedList<>();
		Stack<BinaryTree> s = new Stack();
		q.add(root);
		BinaryTree curr;
		boolean reverse=false;
		
		while(q.size()>=1) {
			
			int count=q.size();
			
			for(int i=0;i<count;i++) {
				curr=q.poll();
				if(reverse==false) {
					
					System.out.print(curr.data+" , ");
					
				}
				else {
				
					s.add(curr);
				}
				
				if(curr.left!=null)
					q.add(curr.left);
				if(curr.right!=null)
					q.add(curr.right);
			}
			if(!s.isEmpty()) {
				while(!s.isEmpty()) {
					System.out.print(s.pop().data+" , ");
				}
			}
			
			reverse=!reverse;
		}
		
		
		
	}
	
	public static BinaryTree buildTree(int[] in,int[] pre,int is,int ie) {
		
		if(is<ie)
			return null;
		BinaryTree root = new BinaryTree(pre[preorder+1]);
		int inIndex=0;
		for(int i=0;i<ie;i++) {
			if(in[i]==root.data) {
				inIndex=i;
				break;
			}
		}
		
		root.left = buildTree(in,pre,is,inIndex-1);
		root.right = buildTree(in,pre,inIndex+1,ie);
		
		return root;
		
		
		
	}
	
	public static int maxWidth(BinaryTree root) {
		int maxWidth=1,count=0;
		BinaryTree curr;
		Queue<BinaryTree> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(q.size()>1) {
			curr=q.poll();
			
			if(curr == null) {
				if(count>maxWidth)
					maxWidth=count;
				count=0;
				q.add(null);
			}
			else {
			if(curr.left!=null) {
				q.add(curr.left);
				count++;
			}
			
			if(curr.right!=null) {
				q.add(curr.right);
				count++;
			}
			}
			
		}
		
		return maxWidth;
		
	}
	
	public static boolean balancedTree(BinaryTree root) {
		if(root == null) {
			return true;
		}
		
		return Math.abs(heightOfTree(root.left)-heightOfTree(root.right))<=1 && balancedTree(root.left) && balancedTree(root.right);
		
	}
	
	public static boolean childSumTree(BinaryTree root) {
		boolean ans = false;
		if(root == null) {
			return true;
		}
		else if(root.left == null && root.right==null) {
			return true; 
		}
		else {
			
			ans = (root.data == (root.left.data+root.right.data)) && childSumTree(root.left) && childSumTree(root.right);
			
		}
		
		return ans;
	}
	
	public static void leftTreeView(BinaryTree root,int level) {
		if(root == null) {
			return;
		}
		
		if(level>maxLevel) {
			System.out.println(root.data);
			maxLevel=level;
		}
		
		leftTreeView(root.left,level+1);
		leftTreeView(root.right,level+1);
		
	}
	
	public static int maxValue(BinaryTree root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		else 
			return Math.max(Math.max(maxValue(root.left),maxValue(root.right)),root.data);
	}
	
	public static void BFS(BinaryTree root) {
		// TODO Auto-generated method stub
		int i=0;
		Queue<BinaryTree> q = new LinkedList<>();
		BinaryTree curr;
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			curr=q.poll();
			
			if(curr == null) {
				System.out.println();
				
				if(!q.isEmpty())
				q.add(null);
			}
			else {
			if(curr.left != null)
			q.add(curr.left);
			
			if(curr.right != null)
			q.add(curr.right);
			
			System.out.print(curr.data+" , ");
			}
			
		
		}
		
		
	}
	
	public static int treeSize(BinaryTree root) {
		if(root == null) {
			return 0;
		}
		else
		return treeSize(root.left)+treeSize(root.right)+1;
	}

	public static void kLevelNodes(BinaryTree root,int k) {
		if(root==null) {
			return;
		}
		if(k==0) {
			System.out.println(root.data);
			return;
		}
		
		kLevelNodes(root.left, k-1);
		
		kLevelNodes(root.right, k-1);
	}

	public static int heightOfTree(BinaryTree root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}
		
		return Math.max(heightOfTree(root.left), heightOfTree(root.right))+1;
	}

	public static void postorderTraversal(BinaryTree root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
	
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.println(root.data);
	}

	public static void preorderTraversal(BinaryTree root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		
		System.out.println(root.data);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		
	}

	public static void inorderTraversal(BinaryTree root) {
		// TODO Auto-generated method stub
		if(root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.println(root.data);
		inorderTraversal(root.right);
	}
	
}
