package Class.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mysort {
	public static void main(String[] args) {
		String[] c={"Red","Green","Blue","Yellow"};
		List<String> colorBank=new ArrayList<>();
		for(String s: c)
			colorBank.add(s);
		System.out.println(colorBank);
		
		//sorting in ascending order
		Collections.sort(colorBank);
		System.out.println(colorBank);
		
		//sorting in reverse order
		Collections.sort(colorBank,Collections.reverseOrder());
		System.out.println(colorBank);
	}
}
