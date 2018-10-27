package Classes;

import java.util.ArrayList;
import java.util.List;

public class PatternClass {
	
	String pattern;
	List<Integer> PrefixTable;
	
	public PatternClass(String newPattern) {
		// TODO Auto-generated constructor stub
		
		pattern= newPattern;
		PrefixTable= new ArrayList<>(pattern.length());

		
	}
	public List<Integer> FailureFunction()
	{
		  int m, k;
		  
		    m=pattern.length();

		    PrefixTable.add(-1);
		    for(int i=1;i<m; i++)
		    	PrefixTable.add(0);
		    k=-1;

		    for(int q=1; q<m; q++)
		    {
		        while(k>=0 && pattern.charAt(k+1)  !=pattern.charAt(q))
		        {
		            k=PrefixTable.get(k);
		        }

		        if(pattern.charAt(k+1)==pattern.charAt(q))
		        {
		            k=k+1;
		        }

		        PrefixTable.set(q, k);
		    }
		    return PrefixTable;
		   

	}
}
