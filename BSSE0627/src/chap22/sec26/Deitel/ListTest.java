package chap22.sec26.Deitel;

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
		list.Insert(6, 4);
		list.Insert(8, 0);
		list.Insert(9, 2);
		list.Insert(2, 3);
		list.Insert(7, 1);
		
	//	list.deleteNode(-1);
	//	list.deleteNode(0);
	//	list.deleteNode(5);
	//	list.deleteNode(1);
	//	list.deleteNode(6);
		list.print();
	} 
}