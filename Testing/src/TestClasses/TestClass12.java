package TestClasses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Class12;

public class TestClass12 {
	Class12 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class12();
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testrun1(){
		List<Integer> arraylist=null;
		obj.run(3, arraylist);
		assertEquals(null, obj.array);
	}
	
	@Test
	public void testrun2(){
		List<Integer> arraylist=new ArrayList<>();
		obj.run(3, arraylist);
		assertEquals(null, obj.array);
	}
	@Test
	public void testrun3(){
		List<Integer> arraylist=new ArrayList<>();
		arraylist.add(1);
		arraylist.add(2);
		obj.run(3, arraylist);
		assertEquals(arraylist, obj.array);
	}
	
}
