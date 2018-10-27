package Classes;

public class Class5 {
	
	public int CCWMethod(Point a, Point b, Point c)
	{
		if(a==null || b==null || c==null)
			return -1;	
		double area=((a.x-b.x)*(b.y-c.y))-((a.y-b.y)*(b.x-c.x));
		if(area>=0) return 1;
		return 0;
	}

}
