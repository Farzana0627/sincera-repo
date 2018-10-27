package TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Class3;
import Classes.Point;

public class TestClass3 {
	Class3 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class3();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testcompare1(){	
		assertEquals(0, obj.compare(null, null));	
	}
	
	@Test
	public void testcompare2(){
		Point p1= new Point(0);
		Point p2= new Point(-2);
		assertEquals(1, obj.compare(p1, p2));
		
	}
}
