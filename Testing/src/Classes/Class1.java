package Classes;

import java.util.List;

public class Class1 {
	public int  k=-1;
	public List<Integer> PrefixTable;
	PatternClass P;
	
	public int[] shifts=new int[10];
	int shiftindex=0;
	public void main(String mainString, String pattern) {
		if(pattern==""){
			return;
		}
		P= new PatternClass(pattern);
		PrefixTable =  P.FailureFunction();
		int n=mainString.length();
		for(int i=0; i<n; i++)
		{ 
			while(k>=0 && pattern.charAt(k+1)!=mainString.charAt(i))	        
			            k=PrefixTable.get(k);
			 if(mainString.charAt(i)==pattern.charAt(k+1))
				 k=k+1;
			 if(k==pattern.length()-1){
				 shifts[shiftindex]=i+1-pattern.length();
				 shiftindex++;
			//	 System.out.println("Pattern occurs with shift "+(i+1-pattern.length()));
			
				 k=PrefixTable.get(k);
			 }	     	
			
		}
	
	}

}
