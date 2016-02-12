import java.util.ArrayList;


public class Main {
	public static void main(String[] args)
	{
		Tree t = new Tree();
		ArrayList<Record> records;
		ArrayList<Attribute> Attributes;
		ArrayList<Record> testRecords;
		FileReaderClass f= new FileReaderClass();
		records = f.buildRecords();
		Attributes= f.getAttributes();
		
		testRecords=f.getTestRecords();
		
	
		Node root = new Node();
	

		for(Record record : records) {
			root.getData().add(record);

		}
		
		t.buildTree(root);

		for(int i=0; i<testRecords.size(); i++){
		
			t.Search(root, testRecords.get(i));
		}
	}
}
