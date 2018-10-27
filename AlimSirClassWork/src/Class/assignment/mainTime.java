package Class.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mainTime {
	public static void main(String[] args) {
		
		// TODO Auto-generated constructor stub
		List<myTime> t= new ArrayList<>();
		t.add(new myTime(10,12,55));
		t.add(new myTime(12,12,17));
		t.add(new myTime(11,21,50));
		t.add(new myTime(9,10,25));
		
		System.out.println(t);
		Collections.sort(t, new MyComparator());
		System.out.println(t);
	}
}
