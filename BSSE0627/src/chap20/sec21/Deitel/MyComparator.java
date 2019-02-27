package chap20.sec21.Deitel;

import java.util.Comparator;

public class MyComparator implements Comparator<Double>  {


	@Override
	public int compare(Double o1, Double o2) {
		// TODO Auto-generated method stub
		if(o1>o2) return -1;
		else if(o1<o2) return 1;
		return 0;
	} 
	
	
	
}
