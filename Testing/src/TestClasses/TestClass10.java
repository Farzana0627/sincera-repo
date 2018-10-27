package TestClasses;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import Classes.Class10;

public class TestClass10 {
	Class10 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class10();
		
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void testconvertion1(){	
		assertEquals(-1, obj.convertion(""), 0.0);

	}

	@Test
	public void testconvertion2(){
		obj.convertion(null);
		assertEquals(-1, obj.convertion(""), 0.0);
	}
	
	@Test
	public void testconvertion3(){
		assertEquals(5, obj.convertion("12"),0.0);
	}
}
