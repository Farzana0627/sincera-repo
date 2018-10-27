import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyMain {
	public static void main(String[] args) {
		Buffer b= new SynchronizedBuffer();
		//Buffer b= new UnsynchronizedBuffer();
		Producer p =new Producer (b);
		Consumer c= new Consumer(b);
		System.out.println("\tvalue \tsum \tread \tsum");
		ExecutorService e=Executors.newCachedThreadPool();
		e.execute(p);
		e.execute(c);
	}
}
