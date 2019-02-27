package chap26.sec11.Deitel;

import java.util.Random;

public class producer implements Runnable{
	final Buffer SharedBuffer;
	final Random r = new Random();
	
	
	public producer(Buffer a)
	{
		SharedBuffer = a;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for(int i =0;i<10;i++)
		{
			try {
				Thread.sleep(r.nextInt(3000));
				SharedBuffer.Write(i);
				
				//System.out.print("\t"+i);
				sum=+i;
				//System.out.print("\t"+sum +"\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//System.out.println("Producer done writing.\n Terminating producer.");
	}

}