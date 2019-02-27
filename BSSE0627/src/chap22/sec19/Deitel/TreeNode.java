package chap22.sec19.Deitel;


public class TreeNode <T extends Comparable<T>>{
	
	TreeNode < T > leftChild;
	TreeNode < T > rightChild;
	T data;
	
	public TreeNode(T nodeData) {
		data = nodeData;
		leftChild = rightChild = null;
	}
	
	public void insert(T insertValue)
	{
		if(insertValue.compareTo(data)<=0)
		{
			if(leftChild==null)
				leftChild = new TreeNode<T>(insertValue);
			else leftChild.insert(insertValue);
		}
		
		else if(insertValue.compareTo(data)>0)
		{
			if(rightChild==null)
				rightChild = new TreeNode<T>(insertValue);
			else rightChild.insert(insertValue);
		}
	}

}