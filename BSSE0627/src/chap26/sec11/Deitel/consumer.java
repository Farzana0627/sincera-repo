package chap26.sec11.Deitel;

import java.util.Random;

public class consumer implements Runnable {
	final Buffer SharedBuffer;
	final Random r = new Random();
	
	public consumer(Buffer a) {
		SharedBuffer =a;
	}
	
	
	public void run()
	{
		int sum =0;
		
		for(int i=0;i<10;i++)
		{
			try {
				Thread.sleep(r.nextInt(3000));
				int value = SharedBuffer.Read();
				//System.out.printf("\t%d",value);
				sum +=value;
	           // System.out.printf("\t\t\t%2d\n",sum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//System.out.printf( "\n%s %d\n%s\n",
			// "Consumer read values totaling", sum, "Terminating Consumer" );
	}
	

}