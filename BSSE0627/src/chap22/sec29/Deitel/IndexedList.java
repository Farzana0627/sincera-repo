package chap22.sec29.Deitel;
import chap22.sec26.Deitel.*;

public class IndexedList
{
	@SuppressWarnings("rawtypes")
	private List[] indexArray;
	
	public IndexedList()
	{
		indexArray = new List[ 26 ];
		for (int i = 0; i < 26; i++ )
		{
			indexArray[ i ] = new List<>();
		}
	}
	public void print()
	{
		for ( int i = 0; i < 26; i++ )
		{
			System.out.print( ( char )( i + 'a' ) + ": " );
			indexArray[ i ].print();
		}
	}
	private int getIndex( String name )
	{
		return name.charAt( 0 ) - 'a';
	}
	
	@SuppressWarnings("unchecked")
	public void insertInIndexedList( String name )
	{
		int index = getIndex( name );
		
		List<String> list = indexArray[ index ];
	
		ListNode<String> startingNode = list.getFirstNode() ;
		
		//empty
		if ( startingNode == null )
			list.insertAtFront( name );
		
		//only one element
		else if ( startingNode.nextNode == null )
			
		//checking priority
		if ( name.compareTo(startingNode.getData()) > 0 ) 
			list.insertAtBack( name );
		else
			list.insertAtFront( name );
		
		//more than one element
		else {
			
			while ( startingNode.getNext().getNext() != null && name.compareTo( startingNode.getNext().getData() ) > 0 )
				startingNode = startingNode.getNext();
			
			if ( startingNode.getNext().getNext() == null && name.compareTo(startingNode.getNext().getData()) > 0 )
				list.insertAtBack( name ); 
			
			else {
				ListNode<String> insert = new ListNode<String>( name );
				insert.setNext( startingNode.getNext() );
				startingNode.setNext( insert );
			}
		}
	}
	
	public void searchIndexedList( String name )
	{
		int index = getIndex(name); 
		@SuppressWarnings("unchecked")
		List<String> list = indexArray[ index ]; 
		list.Search(name);
	}

	
	public void deleteNode(String name) throws Exception
	{
		int index = getIndex(name); 
		@SuppressWarnings("unchecked")
		List<String> list = indexArray[ index ]; 
		list.deleteNode(name);
	
	}
}
