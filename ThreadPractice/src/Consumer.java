import java.util.Random;


public class Consumer implements Runnable{
	final Buffer sharedLocation;
	final Random r= new Random();
	public Consumer(Buffer a) {
		// TODO Auto-generated constructor stub
		sharedLocation=a;
	}
	@Override
	public void run() {
		// TODO Auto-gene																																																																																																					rated method stub
		int sum=0;
		for(int i=1; i< 10; i++)
		{
			try {
				Thread.sleep(r.nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int value=sharedLocation.read();
			System.out.printf("\t%d",value);
			sum+=i;
			System.out.println("\t"+sum);
		}
		System.out.println();
		System.out.println("Consumer has done reading");
	}
	
}
