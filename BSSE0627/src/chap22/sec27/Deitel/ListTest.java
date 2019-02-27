package chap22.sec27.Deitel;


public class ListTest{
	public static void main( String[] args ) throws Exception 
	{
		List< Integer > list = new List< Integer >(); 
		
		list.insertAtFront( -1 );
		list.print();
		list.insertAtFront( 0 );
		list.print();
		list.insertAtBack( 1 );
		list.print();
		list.insertAtBack( 5 );
	
		list.print();
		
	} 
}
