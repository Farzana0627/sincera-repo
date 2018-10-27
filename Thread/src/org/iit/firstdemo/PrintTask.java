package org.iit.firstdemo;

import java.util.Random;

public class PrintTask implements Runnable{
	
	String taskName;
	Random generator= new Random();
	
	public PrintTask(String name)
	{
		this.taskName=name;
	}
	public void run()
	{
		//int sleep = generator.nextInt(1000);
		int sleep=Math.abs(generator.nextInt())%1000;
		System.out.println(taskName+"going to sleep for "+ sleep);
		
		try{
			Thread.sleep(sleep);
		}catch (InterruptedException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(taskName+"awakened");
	}
}
