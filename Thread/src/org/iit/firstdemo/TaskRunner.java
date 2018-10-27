package org.iit.firstdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRunner {

	public static void main(String args[])
	{
		PrintTask T1= new PrintTask("Task 1");
		PrintTask T2= new PrintTask("Task 2");
		PrintTask T3= new PrintTask("Task 3");
		PrintTask T4= new PrintTask("Task 4");
		
	//	Thread t= new Thread(T1);
		ExecutorService t= Executors.newCachedThreadPool();
		t.execute(T1);
		t.execute(T2);
		t.execute(T3);
		t.execute(T4);
		
		System.out.println("Main ends");
	}
}
