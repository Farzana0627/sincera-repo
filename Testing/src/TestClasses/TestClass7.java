package TestClasses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Class7;

public class TestClass7 {
	Class7 obj;
	@Before
	public void setUp() throws Exception {
		obj = new Class7();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testmain(){
		
		String[] c={};
		assertEquals(null, obj.colorBank);
		
	}
}
