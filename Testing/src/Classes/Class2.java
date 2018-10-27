package Classes;

public class Class2 {
	
	public boolean isEven=false;
	public boolean isOdd=false;
	public void find_even_odd(int index){
			if(index==0) return;
	       int n=10;
	       
	       while(index<=n){
	       	if (index%2==0){
	        		System.out.println("even");
	        		isEven=true;
	        		return;
	       	}
	        	if(index%2==1){
	        		System.out.println("odd");
	        		isOdd=true;
	        		return;
	        	}
	        	index++;
	        }
	}

}
