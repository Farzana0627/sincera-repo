package TestClasses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Class11;

public class TestClass11 {
	Class11 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class11();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testremovecolor1(){
		List<String> l1= null;
		List<String> l2= null;
		obj.removeColor(l1, l2);
		assertEquals(1, obj.flag);
		
	}
	
	@Test
	public void testremovecolor2(){
		List<String> l1= new ArrayList<>();
		List<String> l2= new ArrayList<>();
		obj.removeColor(l1, l2);
		assertEquals(1, obj.flag);
		
	}
	
	@Test
	public void testremovecolor3(){
		List<String> l1= new ArrayList<>();
		List<String> l2= new ArrayList<>();
		l1.add("a");
		l1.add("b");
		l2.add("c");
		l2.add("d");
		obj.removeColor(l1, l2);
		assertEquals(l1, obj.List1);
		assertEquals(l2, obj.List2);
		
	}
}
