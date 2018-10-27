package kmp.co.iit;

import java.util.List;
import java.util.Scanner;

public class mainKMP {
	public static void main(String[] args) {
		
		//Taking the text and pattern inputs
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the main string: ");
		String mainString= s.nextLine();
		System.out.println("Enter the pattern: ");
		String pattern=s.nextLine();
		s.close();
		//end taking inputs
		
		PatternClass P= new PatternClass(pattern);
		List <Integer> PrefixTable =  P.FailureFunction();
		System.out.println(PrefixTable);
		int  k=-1,n=mainString.length();
		
		//Pattern matching begins   
		for(int i=0; i<n; i++)
		    {
		    	//System.out.println(""+i+1+" "+k);
		   
		        while(k>=0 && pattern.charAt(k+1)!=mainString.charAt(i))
		        {
		         //  System.out.println(""+PrefixTable.get(k));
		        
		            k=PrefixTable.get(k);
		        }

		        if(mainString.charAt(i)==pattern.charAt(k+1))
		        {
		            k=k+1;
		        }

		        if(k==pattern.length()-1)
		        {
		        	System.out.println("Pattern occurs with shift "+(i+1-pattern.length()));
		        	// cout << "Pattern occurs with shift " << i+1-m << "\n" << endl;
		            k=PrefixTable.get(k);
		        }
		    }
		System.out.println(k);
		//End pattern matching
		
		/*
		int i=0;
		for(int j=0; j< mainString.length(); j++)
		{
			if(i>0 && pattern.charAt(i)!= mainString.charAt(j))
			{
				j=j-PrefixTable.get(i);
				i=0;
			}
			if(pattern.charAt(i)== mainString.charAt(j) )
				i++;
			if(i==pattern.length())
			{	
				System.out.println("Match found at "+ (j+1-pattern.length()));
				i=0;
			}
		}
		
		 */
		 
	}		
}


