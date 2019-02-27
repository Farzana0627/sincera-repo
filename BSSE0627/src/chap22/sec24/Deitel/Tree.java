package chap22.sec24.Deitel;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Tree <T extends Comparable<T>>{
	private int hr,hl,h;
	private TreeNode<T> root;
	int noOfNodes=0;
	
	public Tree()
	{
		root=null;
	}
	public void getDepth()
	{
		System.out.println(Height(root));
	} 
	
	
	public int Height(TreeNode<T> node)
	{
	     if(node==null)
	     return -1; 
	        hl = Height( node.leftChild); 
	        hr = Height( node.rightChild); 
	        h = 1 + Math.max(hl, hr); 
	   return h;
	}
	
	public void insertNode(T insertValue)
	{
		noOfNodes++;
		if(root==null)
			root = new TreeNode<T>(insertValue);
		
		else root.insert(insertValue);
	}
	
	public void preorderTraversal()
	{
		preorderHelper(root);
		System.out.println();
	}
	
	public void preorderHelper(TreeNode<T> node)
	{
		if(node==null)
			return;
		System.out.printf("%s ",node.data);
		preorderHelper(node.leftChild);
		preorderHelper(node.rightChild);
	}
	
	public void inorderTraversal()
	{
		inorderHelper(root);
		System.out.println();
	}
	
	public void inorderHelper(TreeNode<T> node)
	{
		if(node==null)
			return;
		inorderHelper(node.leftChild);
		System.out.printf("%s ",node.data);
		inorderHelper(node.rightChild);
	}
	
	public void postorderTraversal()
	{
		postorderHelper(root);
		System.out.println();
	}
	
	public void postorderHelper(TreeNode<T> node)
	{
		if(node==null)
			return;
		postorderHelper(node.leftChild);
		postorderHelper(node.rightChild);
		System.out.printf("%s ",node.data);
	}
	 public void levelOrder()
	 {
		 Queue<TreeNode<T>> myQueue= new PriorityQueue<TreeNode<T>>(noOfNodes, new Comparator<TreeNode<T>>() {
			 public int compare(TreeNode<T> o1, TreeNode<T> o2) {
					// TODO Auto-generated method stub
					if(o1.data.compareTo(o2.data)<0) return 0;
					else if(o1.data.compareTo(o2.data)>0) return 0;
					return 0;
				}
		});
		 myQueue.add(root);
		 while(!myQueue.isEmpty())
		 {
			 TreeNode<T> node= myQueue.element();
			 myQueue.poll();
			 System.out.printf("%s ",node.data);
			 if(node.leftChild!=null)
				 myQueue.add(node.leftChild);
			 if(node.rightChild!=null)
				 myQueue.add(node.rightChild);
		 }
	 }
	

}
