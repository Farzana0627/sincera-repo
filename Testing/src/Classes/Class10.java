package Classes;

public class Class10 {
	public double sum;
	public String number;
	public double convertion(String number)
	{
		
		if(number=="" || number==null) {
			return -1;
		}
	
		int i=0;
		double numLen= number.length();
		do{
			String s= ""+number.charAt(i);
			int x= Integer.parseInt(s);
			double value= x*(Math.pow(2, numLen)-1);
			sum= sum+value;
			numLen--;
			i++;
		}while (numLen!=0);
			
		return sum;
	 
	}

}
