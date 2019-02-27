package chap22.sec27.Deitel;

import java.util.EmptyStackException;


public class List< T >
{
	private ListNode< T > firstNode;
	//private ListNode< T > lastNode;
	private String name;


	public List()
	{
		this( "list" );
	} 

	public List( String listName )
	{
		name = listName;
		firstNode= null;
	} 
	public void insertAtFront( T insertItem )
	{
		if ( isEmpty() )
			firstNode= new ListNode< T >( insertItem );
		else 
			firstNode =new ListNode< T >( insertItem, firstNode );
	} 
	
	public void insertAtBack( T insertItem )
	{
		if (isEmpty())
			firstNode = new ListNode<T>( insertItem );
		
		else if ( firstNode.nextNode == null )
			firstNode.nextNode = new ListNode<T>( insertItem );
		
		else
		{
			ListNode<T> temp = firstNode;
			
			while ( temp.nextNode != null )
				temp = temp.nextNode;
			temp.nextNode = new ListNode<T>( insertItem );
		}
	} 
	
	public T removeFromFront()  throws EmptyStackException
	{
		T removedItem = firstNode.data;
		if ( isEmpty() ) 
			throw new EmptyStackException( );
		
		else if(firstNode.nextNode==null)
			firstNode=null;
		
		else firstNode = firstNode.nextNode;
		return removedItem; 
	} 
	
	public T removeFromBack() throws Exception
	{
		T removeItem=null;
		if ( isEmpty() )
			throw new Exception( name );
		
		
		else if ( firstNode.nextNode == null ) 
		{
			removeItem = firstNode.data;
			firstNode = null;
		}
			
		else 
		{
			ListNode<T> temp = firstNode;
			while ( temp.nextNode.nextNode != null )
				temp = temp.nextNode;
			
			removeItem = temp.nextNode.data;
			temp.nextNode = null;
			
		}
		return removeItem;
	}
	
	public boolean isEmpty()
	{
		return firstNode == null; 
	} 
	public void print()
	{
		if ( isEmpty() )
			
		{
	
			System.out.printf( "Empty %s\n", name );
	
			return;
	
		} 
	
		System.out.printf( "The %s is: ", name );
	
		ListNode< T > current = firstNode;
	
	
		while ( current != null )
	
		{
	
			System.out.printf( "%s ", current.data );
	
			current = current.nextNode;
	
		} 
	
	
		System.out.println( "\n" );
	
	} 
	
} 
