package TestClasses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Class4;
import Classes.Point;
public class TestClass4 {
	Class4 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class4();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGrahamScan(){
		
		List<Point> points= new ArrayList<>();
		
		assertEquals(null, obj.GrahamScan(points));
		
		
	}
	@Test
	public void testGrahamScan2(){
		
		Point p1= new Point(1);
		Point p2= new Point(2);
		Point p3= new Point(3);
		Point p4= new Point(4);
		Point p5= new Point(5);
		List<Point> points= new ArrayList<>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		List<Point> ExpectedPoints= new ArrayList<>();
		ExpectedPoints.add(p1);
		ExpectedPoints.add(p4);
		
		assertEquals(ExpectedPoints, obj.GrahamScan(points));
		
		
	}
}
