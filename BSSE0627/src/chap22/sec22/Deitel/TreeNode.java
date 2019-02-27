package chap22.sec22.Deitel;


public class TreeNode <T extends Comparable<T>>{
	
	TreeNode < T > leftChild;
	TreeNode < T > rightChild;
	TreeNode < T > Parent;
	T data;
	
	public TreeNode(T nodeData) {
		data = nodeData;
		leftChild = rightChild = Parent=null;
	}
	
	public void insert(T insertValue)
	{
		if(insertValue.compareTo(data)<=0)
		{
			if(leftChild==null){
				leftChild = new TreeNode<T>(insertValue);
				leftChild.Parent=this;
			}
			else leftChild.insert(insertValue);
		}
		
		else if(insertValue.compareTo(data)>0)
		{
			if(rightChild==null){
				rightChild = new TreeNode<T>(insertValue);
				rightChild.Parent= this;
			}
			else rightChild.insert(insertValue);
		}
	}

}
