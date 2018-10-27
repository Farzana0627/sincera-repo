package Classes;

public class Class8 {
	public int output=0;
	public void recursion(Node root){
		if(root==null){
			output=1;
			return;
		}
		if(root.key==0)
			return;
		else recursion(root.left);
	}	

}
