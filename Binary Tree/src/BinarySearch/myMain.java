package BinarySearch;

public class myMain {
	public static void main(String args[])
	{
		
		int n=10;// number of nodes
		Tree binTree=new Tree(n);
			
		binTree.insertNode(11);
		binTree.insertNode(14);
		binTree.insertNode(13);
		binTree.insertNode(40);
		binTree.insertNode(41);
		binTree.insertNode(34);
		binTree.insertNode(31);
		binTree.insertNode(2);
		binTree.insertNode(27);
		binTree.insertNode(7);
		binTree.insertNode(28);
		binTree.insertNode(35);
		
		binTree.searchNode(7);
		binTree.searchNode(40);
		
		System.out.println("Nodes before deletion:");
		binTree.printNodes();
		
	/*	binTree.deleteNode(2);
		binTree.deleteNode(7);
		binTree.deleteNode(11);
		binTree.deleteNode(34);
		binTree.deleteNode(31);*/
		binTree.deleteNode(40);
		/*binTree.deleteNode(14);
		binTree.deleteNode(13);
		binTree.deleteNode(27);
		binTree.deleteNode(41);
		binTree.deleteNode(28);
		binTree.deleteNode(35);
		*/

		
		System.out.println("Nodes after deletion:");
		binTree.printNodes();
	
	}
}