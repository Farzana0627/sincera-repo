package chap22.sec25.Deitel;


public class Tree <T extends Comparable<T>>{
	
	private TreeNode<T> root;
	
	public Tree()
	{
		root=null;
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
	
	public void outputTree()
	{
		outputTreeHelper(root, 0);
	}
	public void outputTreeHelper(TreeNode<T> current,int totalSpaces)
	{
		if(current!=null)
		{
			outputTreeHelper(current.rightChild, totalSpaces+5);
			for ( int i = 1; i <= totalSpaces; i++ )
				System.out.print( " " );
			System.out.println(current.data);
			
			outputTreeHelper(current.leftChild, totalSpaces+5);
		}
	
	}
}
