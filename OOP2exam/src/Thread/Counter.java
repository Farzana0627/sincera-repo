package Thread;

import java.util.Random;

public class Counter implements Runnable{
	
	private Buffer b; 
	int n=100;
	Random r=new Random();
	public Counter(Buffer bufferedValue) {
		// TODO Auto-generated constructor stub
		b=bufferedValue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<11; i++)
		{
			try {
				Thread.sleep(r.nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			b.store(i);
			System.out.print("\t"+i);
		}
		
	}

}
