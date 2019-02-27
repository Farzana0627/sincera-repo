package chap26.sec11.Deitel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CircularBuffer implements Buffer {

	private final Lock accessLock = new ReentrantLock();
	
	private final Condition canWrite = accessLock.newCondition();
	private final Condition canRead = accessLock.newCondition();
	
	private final int[] buffer = {-1,-1,-1};
	private int writeIndex =0;
	private int readIndex =0;
	private int occupied =0;
	
	
	public void Write(int a) {
		
		accessLock.lock();
		
		try
		{
			while (occupied==buffer.length)
			{
				System.out.printf(" Buffer is full.Producer waits.\n");
				canWrite.await();
				
		 
			}
		
			buffer[writeIndex] = a;
			writeIndex = (writeIndex+1)%buffer.length;
			++occupied;
			displayState( "Producer writes " + a );
			canRead.signalAll();
		
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		finally
		{
			accessLock.unlock();
		}
	}

	
	public void displayState(String string)
	{
		System.out.printf("%s%s%d)\n%s",string, " Buffer cells occupied : ", occupied,"buffer cells : ");
		
		for(int value : buffer)
			System.out.printf(" %2d  ", value);
		System.out.print("\n                ");
		
		for(int i=0;i<buffer.length;i++)
			System.out.print("___  ");
		
		System.out.print("\n                ");
		
		for(int i=0;i<buffer.length;i++)
		{
			if(i==writeIndex && i==readIndex)
				System.out.print(" WR ");
			else if(i==writeIndex)
				System.out.print(" W   ");
			else if(i==readIndex)
				System.out.print("  R  ");
			else 
				System.out.print("     ");
		}
		
		System.out.println("\n");
	}


	public int Read() {
		int readValue=0;
		accessLock.lock();
		
		try {
			
			while(occupied==0)
			{
				System.out.printf("Buffer is empty. consumer waits.\n");
				canRead.await();
				
			}	
			
			readValue = buffer[readIndex];
			readIndex = (readIndex+1)%buffer.length;
			--occupied;
			displayState("Consumer reads "+ readValue);
			canWrite.signalAll();
		
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		finally
		{
			accessLock.unlock();
		}
		
		return readValue;
	}

}
