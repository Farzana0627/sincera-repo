package TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Class5;
import Classes.Point;

public class TestClass5 {
	Class5 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class5();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCCWMethod1(){	
		Point p1= null;
		Point p2= null;
		Point p3= null;
		assertEquals(-1,  obj.CCWMethod(p1, p2, p3));
	}
	@Test
	public void testCCWMethod2(){	
		Point p1= new Point(0,0);
		Point p2= new Point(0,0);
		Point p3= new Point(0,0);
		assertEquals(1,  obj.CCWMethod(p1, p2, p3));
	}
	
}
