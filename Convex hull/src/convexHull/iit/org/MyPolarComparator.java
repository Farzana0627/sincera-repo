package convexHull.iit.org;

import java.util.Comparator;

public class MyPolarComparator implements Comparator<Point>{
	
	@Override
	public int compare(Point p1, Point p2) {
		// TODO Auto-generated method stub
		if(p1.slope>p2.slope) return 1;
		else if(p1.slope<p2.slope) return -1;
		return 1;
	}

}
