package Classes;

import java.util.List;

public class Class12 {
	public List<Integer> array;
	public void run(int startValue, List<Integer> arraylist) {
        
		if(arraylist== null || arraylist.isEmpty()) return;
			array= arraylist;
	       for(int i=startValue; i< startValue+3; i++)
	       {
	             array.add(i);
	       }
	                
	}

}
