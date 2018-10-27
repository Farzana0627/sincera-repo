package TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Class8;

public class TestClass8 {
	Class8 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class8();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testrecursion(){
		obj.recursion(null);
		assertEquals(1, obj.output);
		
	}
}
