package TestClasses;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Class1;

public class TestClass1 {

	Class1 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class1();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testmain1(){
		obj.main("","");
		int[] shiftarray= new int [10];
		
		assertArrayEquals("prefixtable", obj.shifts,shiftarray);
	}
	
	@Test
	public void testmain2(){
		obj.main("b", "abb");
		int[] shiftarray= new int [10];
		
		assertArrayEquals("prefixtable", obj.shifts,shiftarray);
		
	}
	
	@Test
	public void testmain3(){
		obj.main("acacab", "aca");
		int[] shiftarray= new int [10];
		shiftarray[0]=0;
		shiftarray[1]=2;
		assertArrayEquals("prefixtable", obj.shifts,shiftarray);
		
	}
	
	@Test
	public void testmain4(){
		obj.main("ababb", "");
		int[] shiftarray= new int [10];
		assertArrayEquals("prefixtable", obj.shifts, shiftarray);
		
	}
	
}
