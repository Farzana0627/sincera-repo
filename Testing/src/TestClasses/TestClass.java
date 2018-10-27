package TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Class10;

public class TestClass {
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
		obj.convertion("123");
		assertEquals(-1, obj.number);
	}
}
