import java.util.Random;


public class Producer implements Runnable{
	final Buffer sharedLocation;
	final Random r= new Random();
	public Producer(Buffer a) {
		// TODO Auto-generated constructor stub
		sharedLocation=a;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=1; i<10; i++)
		{
			try {
				Thread.sleep(r.nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sharedLocation.write(i);
			System.out.print("\t"+i);
			sum+=i;
			System.out.print("\t"+sum);
			
		}
		System.out.println("Producer has done producing");
		
	}
	
	
}
