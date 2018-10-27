//import java.math.*;
public class Process {
	
	 String number;
	
	public Process(String inputNumber)
	{
		number= inputNumber;
	}
	public double convertion()
	{
		
		int i=0;
		double sum=0;
		double numLen= number.length();
		do{
			String s= ""+number.charAt(i);
			int x= Integer.parseInt(s);
			double value= x*(Math.pow(2, numLen)-1);
			sum= sum+value;
			numLen--;
			i++;
		}	while (numLen!=0);
		
		return sum;
	}
	

}
