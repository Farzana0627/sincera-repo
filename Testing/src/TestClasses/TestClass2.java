package TestClasses;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Class2;

public class TestClass2 {
	Class2 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class2();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testfind_even_odd1(){
		obj.find_even_odd(2);
		//assertTrue(obj.flag);
		assertTrue(obj.isEven);
		
	}
	@Test
	public void testfind_even_odd2(){
		obj.find_even_odd(1);
		assertTrue(obj.isOdd);
	}
	
	@Test
	public void testfind_even_odd3(){
		obj.find_even_odd(0);
		//assertTrue(obj.flag);
		assertFalse(obj.isEven);
		assertFalse(obj.isOdd);
		
	}
	

}
