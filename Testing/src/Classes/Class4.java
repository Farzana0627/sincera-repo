package Classes;

import java.util.List;
import java.util.Stack;

public class Class4 {
	public Stack<Point> GrahamScan(List<Point> hullVertices)
	{
		if(hullVertices.size()<2) return null;
		
		Stack <Point> hullStack= new Stack<>();
		
		hullVertices= getSortedVertices(hullVertices);
		
			
		hullStack.push(hullVertices.get(0));
		hullStack.push(hullVertices.get(1));
		for(int i=2; i< hullVertices.size(); i++)
		{
			Point top= hullStack.pop();
			while((CCWMethod(hullStack.peek(), top, hullVertices.get(i)))==0){
				top=hullStack.pop();
				if (hullStack.isEmpty()) break;
			}
			hullStack.push(top);
			hullStack.push(hullVertices.get(i));
		}
		return hullStack;
	}
	
	private int CCWMethod(Point peek, Point top, Point point) {
		// TODO Auto-generated method stub
		return 0;
	}

	private List<Point> getSortedVertices(List<Point> hullVertices) {
		// TODO Auto-generated method stub
		return hullVertices;
	}




}
