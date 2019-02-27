package chap22.sec17.Deitel;

import java.util.Scanner;

public class TreeTest {

	public static void main(String[] args) {
		Tree<String> tree = new Tree<>();
		
		Scanner scr= new Scanner(System.in);
		System.out.println("Write a sentence: ");
		String s= scr.nextLine();
		scr.close();
		String[] words = s.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		
		for(String word: words)
			tree.insertNode(word);
		
		
		System.out.println("\nInorder Traversal :");
		tree.inorderTraversal();
		
		System.out.println("Preorder traversal :");
		tree.preorderTraversal();
		
		System.out.println("Postorder traversal :");
		tree.postorderTraversal();
	}

}
