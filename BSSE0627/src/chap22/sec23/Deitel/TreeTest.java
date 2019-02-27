package chap22.sec23.Deitel;

import java.util.Random;
import java.util.Scanner;

public class TreeTest {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		
		Random random = new Random();
		
		int value;
		for(int i=0;i<10;i++)
		{
			value = random.nextInt(100);
			System.out.print(value + " ");
			tree.insertNode(value);
		}
		
		
		
		System.out.println("\nInorder Traversal :");
		tree.inorderTraversal();
		
		System.out.println("Preorder traversal :");
		tree.preorderTraversal();
		
		System.out.println("Postorder traversal :");
		tree.postorderTraversal();
		
		System.out.println("Enter a node you want to search: " );
		Scanner scr= new Scanner(System.in);
		int node= scr.nextInt();
		scr.close();
		tree.searchNode(node);
		
	}

}
