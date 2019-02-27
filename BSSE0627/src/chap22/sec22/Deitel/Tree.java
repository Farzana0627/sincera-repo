package chap22.sec22.Deitel;


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
	public TreeNode<T> getMinNode(TreeNode<T> current)
    {
    	while(current.leftChild!=null)
    		current=current.leftChild;
    	return current;
    }
    
    public void deleteNodeWithNoChild(TreeNode<T> current)
    {
    	
    		if(current==root)
    		{		
    			System.out.println(current.data+" deleted!");
    			current = null;
    			root=null;
    			return;
    		}
    		else if(current== current.Parent.leftChild)
    		{
    			System.out.println(current.data+" deleted!");
    			current.Parent.leftChild=null;
    			return;
    		}
    		else
    		{
    			System.out.println(current.data+" deleted!");
    			current.Parent.rightChild=null;
    			return;
    		}
    	
    }
   	public void deleteNodeWithOneChild(TreeNode<T> current)
   	{
   		if(current.rightChild!=null)
   		{
   			if(current==root)
   			{
   				System.out.println(current.data+" deleted!");
   				root=current.rightChild;
   				current.rightChild.Parent=null;
   				
   				return;
   			}
		
   			else if(current== current.Parent.rightChild)
   			{
   				System.out.println(current.data+" deleted!");
   				current.Parent.rightChild=current.rightChild;
   				current.rightChild.Parent=current.Parent;
   			
   				return;
   			}
			
   			else
   			{
   				System.out.println(current.data+" deleted!");
   				current.Parent.leftChild=current.rightChild;
   				current.rightChild.Parent=current.Parent;
   				return;
   			}
   		}
   		else if(current.leftChild!=null)
   		{
    		if(current==root)
    		{
    			System.out.println(current.data+" deleted!");
    			root=current.leftChild;
    			current.leftChild.Parent=null;
    			
    			return;
    		}
    		else if(current== current.Parent.rightChild)
    		{
    			System.out.println(current.data+" deleted!");
    			current.Parent.rightChild=current.leftChild;
    			current.leftChild.Parent=current.Parent;
    			return;
    		}
    		else {
    		
    			System.out.println(current.data+" deleted!");
    			current.Parent.leftChild=current.leftChild;
    			current.leftChild.Parent=current.Parent;
    			return;
    		}
    	}
   	}
   	public void deleteMinNode(TreeNode<T> minNode)
   	{
   		if(minNode.rightChild==null)
    		deleteNodeWithNoChild(minNode);
		else 	
    		deleteNodeWithOneChild(minNode);
   	}
    public void deleteNode(T key)
    {
    	TreeNode<T> current= root;
    	while(true)
    	{
    		if(current==null)
    		{ 		
    			System.out.println("Empty!");
    			return;
    		}
    		else if(current.data==key)
    		{
    			//leaf node
    	    	if(current.leftChild==null && current.rightChild==null){
    	    		deleteNodeWithNoChild(current);
    	    		return;
    	    	}
    	    	
    	    	//node with one child
    	    	else if((current.leftChild==null && current.rightChild!=null) ||(current.rightChild==null && current.leftChild!=null))	
    	    	{
    	    		deleteNodeWithOneChild(current);
    	    		return;
    	    	}
    	    	
    	    	//node with two children
    	    	else if(current.rightChild!=null && current.leftChild!=null)
    	    	{
    	    		
    	    		TreeNode<T> minNode=getMinNode(current.rightChild);
    	    	
    	    		if(current==root)
    	    		{
    	    			System.out.println(current.data+" deleted!");
    	    			current.data=minNode.data;
    	    			deleteMinNode(minNode);
    	    			return;
    	    		}
    	    		if(current==current.Parent.leftChild)
    	    		{
    	    			System.out.println(current.data+" deleted!");
    	    			current.Parent.leftChild.data=minNode.data;
    	    			deleteMinNode(minNode);
    	    			return;
    	    		}
    	    			
    	    		else
    	    		{
    	    			System.out.println(current.data+" deleted!");
    	    			current.Parent.rightChild.data=minNode.data;
    	    			deleteMinNode(minNode);
    	    			return;	
    	    		}	
    	    	}
    		}
    		else if (current.data.compareTo(key) >0 )
    		{		
    			current=current.leftChild;
    		}
    		else 
    		{
    			current=current.rightChild;
    		}
    	}
    	
    }  
}
