package chap22.sec21.Deitel;

import java.util.EmptyStackException;


public class List< T >
{
	public ListNode< T > firstNode;
	public ListNode< T > lastNode;
	public String name;


	public List()
	{
		this( "list" );
	} 

	public List( String listName )
	{
		name = listName;
		firstNode = lastNode = null;
	} 
	public void insertAtFront( T insertItem )
	{
		if ( isEmpty() )
			firstNode = lastNode = new ListNode< T >( insertItem );
		else 
			firstNode =new ListNode< T >( insertItem, firstNode );
	} 
	public void insertAtBack( T insertItem )
	{
		if ( isEmpty() ) 
			firstNode = lastNode = new ListNode< T >( insertItem );
		else {
			lastNode=lastNode.nextNode = new ListNode< T >( insertItem );
			
			
		}
	} 
	public T removeFromFront() throws EmptyStackException
	{
		if ( isEmpty() ) 
			throw new EmptyStackException( );
		T removedItem = firstNode.data;
		if ( firstNode == lastNode )
			firstNode = lastNode = null;
		else
			firstNode = firstNode.nextNode;
		return removedItem; 
	} 
	public T removeFromBack() throws Exception
	{
		if ( isEmpty() )
			throw new Exception( name );
		T removedItem = lastNode.data; 
		
		if ( firstNode == lastNode )
			firstNode = lastNode = null;
		else 
		{
			ListNode< T > current = firstNode;
	
			while ( current.nextNode != lastNode )
				current = current.nextNode;
			lastNode = current; 
			current.nextNode = null;
		} 
		return removedItem;
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
	
	public void Search(T nodeData)
	{
		search( firstNode,nodeData );
	}
	private void search( ListNode<T> current,T nodeData )
	{
		if(current==null){
			System.out.println("Not found!");
			return;
		}
		if ( current.data== nodeData){
			System.out.printf( "%s Found!", current.data );
			return;
		}
		
		else
			search( current.getNext(), nodeData );
		
	}
} 