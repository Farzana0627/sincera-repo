package chap22.sec29.Deitel;



public class ListTest{
	public static void main( String[] args ) throws Exception 
	{
		IndexedList list = new IndexedList(); 
		
		list.insertInIndexedList("muna");
		list.print();
		list.insertInIndexedList("snigdha");
		list.print();
		list.insertInIndexedList("fabiha");
		list.print();
		list.insertInIndexedList("mumu");
	
		list.print();
		
		list.deleteNode("muna");
		list.print();
		list.searchIndexedList("fabiha");
		list.searchIndexedList("muna");
	//	list.deleteNode(5);
	//	list.deleteNode(1);
	//	list.deleteNode(6);
		
	} 
}