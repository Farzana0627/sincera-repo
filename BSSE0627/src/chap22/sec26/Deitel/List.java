package chap22.sec26.Deitel;
import java.util.EmptyStackException;


public class List< T >
{
	public  ListNode< T > firstNode;
	public  ListNode< T > lastNode;
	public  String name;


	public List()
	{
		this( "list" );
	} 

	public ListNode<T> getFirstNode()
	{
		return firstNode;
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
	
	public void deleteNode(T value) throws Exception
	{
		if(isEmpty())
		{
			System.out.println("List is empty!");
			return;
		}
		//firstNOde
		else if(firstNode.data==value)
		{
			removeFromFront();
			return;
		}
		//LastNode
		else if(lastNode.data==value)
		{
			removeFromBack();
			return;
		}
		//internal Nodes
		else
		{
			ListNode<T> current = firstNode.nextNode;
			ListNode<T> previous = firstNode;
			while (current!=lastNode && current.data!= value) 
			{
					previous = current;
					current = current.nextNode;
			}
			
			previous.setNext(current.nextNode);
			return;
			
		}
	
	}
	
	public void Insert(T value, int index)
	{
		if ( isEmpty())
		{
			ListNode<T> newNode = new ListNode<T>(value);
			firstNode = lastNode = newNode;
			return;
		}
		else if(index==0){
			insertAtFront(value);
			return;
		}
		
		
		else {
			ListNode<T> current = firstNode.nextNode;
			ListNode<T> previous = firstNode;
			int pos=1;
			while (current!=null ) 
			{
				if(pos==index)
				{
					previous.setNext(new ListNode<T>(value));
					previous.getNext().setNext(current);
					return;
				}
					previous = current;
					current = current.nextNode;
					pos++;
			}
			if(current==null)
			{
				insertAtBack(value);
			}
			
		}
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