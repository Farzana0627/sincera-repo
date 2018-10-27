package TestClasses;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Class6;
import Classes.myTime;

public class TestClass6 {
	Class6 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class6();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testcompare1(){
		int hour=0, min=0, sec=0;
		myTime o1=new myTime(hour,min,sec);
		myTime o2=new myTime(hour,min,sec);
		obj.compare(o1,o2);
		assertEquals(0, obj.output);
		
	}
	@Test
	public void testcompare2(){
		int hour1=10, min1=0, sec1=0;
		int hour2=5, min2=0, sec2=0;
		myTime o1=new myTime(hour1,min1,sec1);
		myTime o2=new myTime(hour2,min2,sec2);
		
		obj.compare(o1,o2);
		assertEquals(5, obj.output);
		
	}
	
	@Test
	public void testcompare3(){
		int hour1=10, min1=20, sec1=0;
		int hour2=10, min2=10, sec2=0;
		myTime o1=new myTime(hour1,min1,sec1);
		myTime o2=new myTime(hour2,min2,sec2);
		
		obj.compare(o1,o2);
		assertEquals(10, obj.output);
		
	}
}
