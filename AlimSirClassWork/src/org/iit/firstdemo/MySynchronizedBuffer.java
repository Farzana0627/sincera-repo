package org.iit.firstdemo;


public class MySynchronizedBuffer implements Buffer {
	int buffer=-1;
	boolean occupied= false;
	@Override
	public void write(int a) {
		// TODO Auto-generated method stub
		while (occupied)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			buffer =a;
			occupied= true;
			notifyAll();
		}
	}
	@Override
	public int read() {
		// TODO Auto-generated method stub
		while(!occupied)
		{	try
			{
				wait();
			}
			catch(InterruptedException e)
			{
			e.printStackTrace();
			}
			occupied= false;
			notifyAll();
		}
		return 0;
	}
	
	
	
}
