package TestClasses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Classes.I_Shape;
import Classes.Class9;

public class TestClass9 {
	Class9 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class9();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDrawShape1(){
		obj.DrawShape(null);
		assertEquals(0, obj.flag);
		
	}
	
	@Test
	public void testDrawShape2(){
		List<I_Shape> shapes= new ArrayList<>();
		obj.DrawShape(shapes);
		assertEquals(0, obj.flag);
		
	}
}
