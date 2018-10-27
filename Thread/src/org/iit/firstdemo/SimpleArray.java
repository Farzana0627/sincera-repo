package org.iit.firstdemo;

import java.util.Random;

public class SimpleArray {
	int []a;
	int writeIndex =0;
	Random r= new Random();
	
	public SimpleArray(int size)
	{
		a=new int [size];
	}
	
	public void add(int value) {
		int pos=writeIndex;
		a[pos]=value;
		System.out.println("Writing"+ value + "to"+pos+ "th position");
		try {
			Thread.sleep(Math.abs(r.nextInt())%1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		++writeIndex;
		System.out.println("Next write Index: "+ writeIndex);
	}
}
