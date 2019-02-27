package chap22.sec24.Deitel;

import java.util.Random;

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
		
		System.out.println("Level-order traversal :");
		tree.levelOrder();
		
	}

}
