package Classes;

public class Class3 {
	public int compare(Point p1, Point p2) {
		if(p1==null && p2==null) return 0;
				
		if(p1.slope>p2.slope) return 1;
		else if(p1.slope<p2.slope) return -1;
		return 1;
	}

}
