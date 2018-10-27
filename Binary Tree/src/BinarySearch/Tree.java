/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearch;

/**
 *
 * @author Broken
 */
public class Tree {

    public Node Root;
    int noOfNodes=0;
    public Tree(int n) {
        Root = null;
        noOfNodes=n;
    }

    public void insertNode(int key)
    {
        Node current = Root;
        Node parent;
        if (current == null)
        {
            Root = new Node(key);
            return;
        }

        while (true)
        {
            parent = current;
            if (current.Key > key)
            {
       
                current = current.LeftChild;
                if (current == null) {
                    parent.LeftChild = new Node(key);
                    parent.LeftChild.Parent=parent;
                    return;
                }
            } 
            else 
            {
            	current = current.RightChild;
                if (current == null) {
                    parent.RightChild = new Node(key);
                    parent.RightChild.Parent= parent;
                    return;
                }
            }
        }
    }
    public void searchNode(int key)
    {
    	Node current;
    	current= Root;
    	while(true){
    		if(current.Key==key)
    		{
    			System.out.println(current.Key+" Found!");
    			return;
    		}
    		else if (current.Key > key)
    		{
    			current=current.LeftChild;
    		}
    		else 
    		{
    			current=current.RightChild;
    		}
    	}
    }
    //print nodes
    public void InOrderTraversal(Node root)
    {
    	if(root!=null)
    	{
    		InOrderTraversal(root.LeftChild);
    		System.out.println(root.Key);
    		InOrderTraversal(root.RightChild);
    	}
    }

    public void printNodes()
    {
    	if(Root==null){
    		System.out.println("Tree is empty!");
    		return;
    	}
    	System.out.println("Root: "+Root.Key);
    	InOrderTraversal(Root);
    }
    //end print nodes
    
    public Node getMinNode(Node current)
    {
    	while(current.LeftChild!=null)
    		current=current.LeftChild;
    	return current;
    }
    
    public void deleteNodeWithNoChild(Node current)
    {
    	
    		if(current==Root)
    		{		
    			current = null;
    			Root=null;
    			return;
    		}
    		else if(current== current.Parent.LeftChild)
    		{
    			current.Parent.LeftChild=null;
    			return;
    		}
    		else
    		{
    			current.Parent.RightChild=null;
    			return;
    		}
    	
    }
   	public void deleteNodeWithOneChild(Node current)
   	{
   		if(current.RightChild!=null)
   		{
   			if(current==Root)
   			{
   				Root=current.RightChild;
   				current.RightChild.Parent=null;
   				
   				return;
   			}
		
   			else if(current== current.Parent.RightChild)
   			{
   				current.Parent.RightChild=current.RightChild;
   				current.RightChild.Parent=current.Parent;
   			
   				return;
   			}
			
   			else
   			{
   				current.Parent.LeftChild=current.RightChild;
   				current.RightChild.Parent=current.Parent;
   				return;
   			}
   		}
   		else if(current.LeftChild!=null)
   		{
    		if(current==Root)
    		{
    			Root=current.LeftChild;
    			current.LeftChild.Parent=null;
    			
    			return;
    		}
    		else if(current== current.Parent.RightChild)
    		{
    			current.Parent.RightChild=current.LeftChild;
    			current.LeftChild.Parent=current.Parent;
    			return;
    		}
    		else {
    		
    			current.Parent.LeftChild=current.LeftChild;
    			current.LeftChild.Parent=current.Parent;
    			return;
    		}
    	}
   	}
   	public void deleteMinNode(Node minNode)
   	{
   		if(minNode.RightChild==null)
    		deleteNodeWithNoChild(minNode);
		else 	
    		deleteNodeWithOneChild(minNode);
   	}
    public void deleteNode(int key)
    {
    	Node current= Root;
    	while(true)
    	{
    		if(current==null)
    		{ 		
    			System.out.println("Empty!");
    			return;
    		}
    		else if(current.Key==key)
    		{
    			//leaf node
    	    	if(current.LeftChild==null && current.RightChild==null){
    	    		deleteNodeWithNoChild(current);
    	    		return;
    	    	}
    	    	
    	    	//node with one child
    	    	else if((current.LeftChild==null && current.RightChild!=null) ||(current.RightChild==null && current.LeftChild!=null))	
    	    	{
    	    		deleteNodeWithOneChild(current);
    	    		return;
    	    	}
    	    	
    	    	//node with two child
    	    	else if(current.RightChild!=null && current.LeftChild!=null)
    	    	{
    	    		
    	    		Node minNode=getMinNode(current.RightChild);
    	    	
    	    		if(current==Root)
    	    		{
    	    		
    	    			current.Key=minNode.Key;
    	    			deleteMinNode(minNode);
    	    			return;
    	    		}
    	    		if(current==current.Parent.LeftChild)
    	    		{
    	
    	    			current.Parent.LeftChild.Key=minNode.Key;
    	    			deleteMinNode(minNode);
    	    			return;
    	    		}
    	    			
    	    		else
    	    		{
    
    	    			current.Parent.RightChild.Key=minNode.Key;
    	    			deleteMinNode(minNode);
    	    			return;	
    	    		}	
    	    	}
    		}
    		else if (current.Key > key)
    		{		
    			current=current.LeftChild;
    		}
    		else 
    		{
    			current=current.RightChild;
    		}
    	}
    	
    }  
}
   
    	
   
    



