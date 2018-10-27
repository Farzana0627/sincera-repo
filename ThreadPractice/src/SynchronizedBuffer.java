
public class SynchronizedBuffer implements Buffer {
	
	private int buffer= -1;
	private boolean occupied = false;
	
	
	public synchronized void write(int value)
	{
		while (occupied) 
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			buffer= value;
			occupied= true;
			//displayState("Producer writes "+ buffer);
			notifyAll();
			
		
	}
	
	public void displayState(String operation)
	{
		System.out.printf("\t",operation, buffer, occupied);
	}

	@Override
	public synchronized int read() {
		// TODO Auto-generated method stub
		while(!occupied)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		occupied= false;
		//displayState("Consumer reads "+ buffer);
		
		notifyAll();
		return buffer;
	}
}
