package chap22.sec19.Deitel;


public class Tree <T extends Comparable<T>>{
	private int hr,hl,h;
	private TreeNode<T> root;
	
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
	

}
