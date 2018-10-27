package convexHull.iit.org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MainConvexHull {
	public static void main(String[] args) {
		
		Scanner scr= new Scanner (System.in);
		System.out.println("No of Vertices: ");
		int noOfVertices= scr.nextInt();
		double x, y;
		System.out.println("Co-ordinates: ");
		List<Point> vertices= new ArrayList<>();
		for(int i=0; i< noOfVertices; i++){
			for(int j=1; j<2; j++)
			{	
				x=scr.nextDouble();
				y=scr.nextDouble();
				vertices.add(new Point(x,y));
			}
			
		}
		scr.close();
	
		ConvexHull convexHull= new ConvexHull();
		//Graham scan
		Stack <Point> hullStack= new Stack<>();
		hullStack=convexHull.GrahamScan(vertices);
		
		//System.out.println("\nPolygon Vertices:");
		//for(int i=0; i< hullStack.size(); i++)
			//System.out.println(hullStack.get(i).x+" "+hullStack.get(i).y);
		
		//Quick Hull
		QuickHull quickHull= new QuickHull();
		vertices=quickHull.QuickHull(vertices);
		
		System.out.println("\nPolygon Vertices:");
		for(int i=0; i< vertices.size(); i++)
			System.out.println(vertices.get(i).x+" "+vertices.get(i).y);
		
		
	}
}

