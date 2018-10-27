package convexHull.iit.org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class ConvexHull {
	
	public int CCWMethod(Point a, Point b, Point c)
	{
		double area=((a.x-b.x)*(b.y-c.y))-((a.y-b.y)*(b.x-c.x));
		if(area>=0) return 1;
		return 0;
	}
	
	public List<Point> getSortedVertices(List<Point> pointList )
	{
		Collections.sort(pointList , new MyYComparator());

		Point reference=pointList.get(0);
		for(int i=1; i< pointList.size(); i++)
		{
			double m=Math.atan2(pointList.get(i).y-reference.y, pointList.get(i).x-reference.x);
			pointList.get(i).setSlope(m);
		}
	
		Collections.sort(pointList , new MyPolarComparator());
		
		return pointList;
	}
	
	public Stack<Point> GrahamScan(List<Point> hullVertices)
	{
		Stack <Point> hullStack= new Stack<>();
		hullVertices= getSortedVertices(hullVertices);
		
		hullStack.push(hullVertices.get(0));
		hullStack.push(hullVertices.get(1));
		for(int i=2; i< hullVertices.size(); i++)
		{
			Point top= hullStack.pop();
			while((CCWMethod(hullStack.peek(), top, hullVertices.get(i)))==0)
				top=hullStack.pop();
			hullStack.push(top);
			hullStack.push(hullVertices.get(i));
		}
		return hullStack;
	}
	
	public List <Double> getXlist(List<Point> hullVertices)
	{
		List <Double> xList= new ArrayList<>();
		for(Point a: hullVertices)
			xList.add(a.x);
		return xList;
		
	}
	
	public List<Double> getYlist(List<Point> hullVertices)
	{
		List <Double> yList= new ArrayList<>();
		for(Point a: hullVertices)
			yList.add(a.x);
		return yList;
		
	}
	
    public int pointLocation(Point A, Point B, Point P)

    {

        Double cp1 = (B.x - A.x) * (P.y - A.y) - (B.y - A.y) * (P.x - A.x);

        if (cp1 > 0)

            return 1;

        else if (cp1 == 0)

            return 0;

        else

            return -1;

    }
    public Point MaxDistantPoint(Point a, Point b, List<Point> list)

    {
    	
    	double MaxArea=0;
    	int index=0;
    	for(Point c: list)
		{
    		Double area=Math.abs(((a.x-b.x)*(b.y-c.y))-((a.y-b.y)*(b.x-c.x)));
    		if(area>MaxArea){
    			MaxArea=area;
    			index= list.indexOf(c);
    		}
		}
    	return list.get(index);
		
	}
    public void hullSet(Point A, Point B, List<Point> set, List<Point> hull)
    {
    	if(set.size()==0) return;
    	Point p= MaxDistantPoint(A, B, set);
    	set.remove(p);
    	hull.add(p);
    	List<Point> LeftSet= new ArrayList<>();
    	List<Point> RightSet= new ArrayList<>();
    	for(Point point:set)
    	{
    		if((CCWMethod(A,p,point))==1) LeftSet.add(point);
    		if((CCWMethod(p,B,point))==1) RightSet.add(point);
    	}
    	hullSet(A,p,LeftSet,hull);
    	hullSet(p,B,RightSet,hull);
    }
    
	public List<Point> QuickHull(List<Point> Vertices)
	{
		List<Point> hullVertices= new ArrayList<>();
		Collections.sort(Vertices,new MyXComparator());
		Point maxX=Vertices.get(0);
		Point minX=Vertices.get(Vertices.size()-1);
		hullVertices.add(maxX);
		hullVertices.add(minX);
		Vertices.remove(Vertices.size()-1);
		Vertices.remove(0);
		
		List<Point> LeftSet= new ArrayList<>();
		List<Point> RightSet= new ArrayList<>();
		Point A=minX;
		Point B= maxX;
		for(int i=0; i<Vertices.size(); i++)
		{
			Point P= Vertices.get(i);
            if (pointLocation(A, B, P) == -1)

                LeftSet.add(P);

            else if (pointLocation(A, B, P) == 1)

                RightSet.add(P);
		}
        hullSet(A, B, RightSet, hullVertices);

        hullSet(B, A, LeftSet, hullVertices);
		
		return hullVertices;
		
	}
	
	
}
