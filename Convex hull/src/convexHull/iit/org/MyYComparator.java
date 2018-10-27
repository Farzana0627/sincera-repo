package convexHull.iit.org;

import java.util.Comparator;

public class MyYComparator implements Comparator<Point>{
	
	@Override
	public int compare(Point p1, Point p2) {
		// TODO Auto-generated method stub
		if(p1.y>p2.y) return 1;
		else if(p1.y< p2.y ) return -1;
		return 0;
	}
}

